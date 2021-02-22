package server;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author ziy
 * @date 2020/6/16 14:10
 * @version 1.0
 * TODO：基于NIO实现的聊天室应用----服务器端程序
 */
public class Server {
    /**
     * @param log 日志输出
     */
    private static PrintWriter log;
    /**
     * @param PORT 程序端口号
     */
    private static final int PORT = 49699;
    /**
     * @param sip 套接字IP地址
     */
    private static InetSocketAddress sip;
    /**
     * @param selector 监听器实例
     */
    private Selector selector;
    /**
     * @param server 服务器端的套接字通道
     */
    private ServerSocketChannel server;
    /**
     * @param pool 线程池
     */
    private ForkJoinPool pool;
    /**
     * @param charset 定义字符集
     */
    private Charset charset = Charset.forName("utf-8");
    /**
     * @param tempSet 保存临时集合
     */
    private SelectionKey[] tempSet;
    /**
     * @param nameMap 是客户机IP地址-客户机名称的映射
     */
    HashMap<SocketAddress, String> nameMap = new HashMap();
    /**
     * 隐藏构造器
     */
    private Server(){}

    /**
     * 服务器主程序入口
     * @throws InterruptedException 线程休眠失败
     */
    public void server()
            throws InterruptedException {
        try {
            //打开一个监听器
            selector = Selector.open();
            //打开一个ServerSocketChannel以ACCEPT注册到监听器
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.register(selector, SelectionKey.OP_ACCEPT);
            //利用多核CPU---异步处理每一个IO操作
            pool = ForkJoinPool.commonPool();
            //开始监听
            while(selector.select() > 0) {
                Set<SelectionKey> keys = selector.selectedKeys();
                //删除全部
                keys.removeAll(keys);
                //转为数组
                SelectionKey[] keysArr = keys.toArray(SelectionKey[]::new);
                //copy一份临时数组
                tempSet = Arrays.copyOfRange(keysArr, 0, keysArr.length);
                //提交任务
                pool.submit(new MyTask(keysArr));
            }
        } catch (IOException e) {
            //监听器打开失败
            log.print(e.getMessage() +"\n");
            log.print("创建必要对象时出现未知异常，程序即将结束");
            Thread.sleep(2 * 1000);
            //结束程序
            System.exit(-1);
        }
    }

    /**
     * 内部类，提交该实例可并行执行任务
     */
    private class MyTask extends RecursiveAction {

        SelectionKey[] keys;
        private MyTask(SelectionKey[] keys) {
            this.keys = keys;
        }

        @Override
        protected void compute() {
            if(keys.length > 0) {
                try {
                    if(keys.length == 1) {
                        //处理该操作
                        for (SelectionKey key : keys) {
                            isThings(key);
                        }
                    }
                    else if(keys.length/2 > 0){
                        MyTask task1 = new MyTask(Arrays.copyOfRange(keys, 0, keys.length / 2));
                        MyTask task2 = new MyTask(Arrays.copyOfRange(keys, keys.length / 2, keys.length));
                        task1.fork();
                        task2.fork();
                    }
                } catch (IOException e) {
                    log.print(e.getMessage() +"\n");
                }
            }
            else {
                return;
            }
        }
        private void isThings(SelectionKey key)
                throws IOException {
            try {
                //如果key是连接请求
                if(key.isAcceptable()) {
                    //服务器接收连接,返回对应的通道
                    SocketChannel sc = server.accept();
                    //将此Channel注册到监听器上----以监听读操作注册
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                    //注册姓名
                    String name = sc.toString();
                    name = name.substring(0, name.indexOf("@"));
                    nameMap.put(sc.getRemoteAddress(), name);

                    //通过修改interestOps确保下一次该key也是监听OP_ACCEPT，防止之前意外修改
                    key.interestOps(SelectionKey.OP_ACCEPT);
                }
            } catch (IOException e) {
                log.print(e.getMessage() +"\n");
            }

                //如果是读操作----限制客户机输入内容的长度
            if(key.isReadable()) {
                //将信息读取出来
                SocketChannel channel = (SocketChannel) key.channel();

                ByteBuffer buff = ByteBuffer.allocate(1024);
                String content = nameMap.get(channel.getRemoteAddress()) +":";
                try {
                    while ((channel.read(buff)) > 0) {
                        buff.flip();
                        content += charset.decode(buff);
                    }

                    key.interestOps(SelectionKey.OP_READ);
                    //将信息发送到每个客户机
                    //判断信息是不是空的
                    if(content.length() > 0) {
                        for (SelectionKey sk : Server.this.tempSet) {
                            SelectableChannel sc = sk.channel();
                            if(sc instanceof SocketChannel) {
                                SocketChannel cc= (SocketChannel)sc;
                                cc.write(charset.encode(content));
                            }
                        }
                    }
                } catch (IOException e) {
                    //读操作异常-----说明客户机和服务器出现连接异常，所以该对应的key没必要存在于监听器中
                    selector.keys().remove(key);
                    if (channel != null) {
                        channel.close();
                    }
                    log.print(e.getMessage() +"\n");
                }
            }
        }
    }

    /**
     *
     *
     * 静态方法，传入String 的IP地址
     * @param ip
     * @return Server 返回初始化好的一个Server实例
     */
    public static Server Start(String ip)
            throws IOException {
        //创建日志文件
        File logFile = File.createTempFile("log", "txt");
        Server.log = new PrintWriter(logFile);

        try {
            //初始化程序配置
            String[] field = ip.split("\\.");
            byte[] bytes = new byte[field.length];
            for (int i = 0; i < field.length; i++) {
                bytes[i] = Integer.valueOf(field[i]).byteValue();
            }
            sip = new InetSocketAddress(InetAddress.getByAddress(bytes), PORT);
            return new Server();
        } catch(Throwable e) {
            //服务器端程序初始化失败
            log.print("服务器程序初始化失败" +"\n");
            System.out.println("cuoc");
            return null;
        }
    }
}

class Test {
    public static void main(String[] args)
            throws IOException, InterruptedException {
        Server.Start("192.168.3.108").server();
    }
}
