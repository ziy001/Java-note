package client;

import server.Server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author ziy
 * @date 2020/6/16 14:10
 * @version 1.0
 * TODO：基于NIO的聊天室应用----客户端程序
 */
public class Client {
    /**
     * @param PORT 端口号
     */
    private static final int PORT = 5900;
    /**
     * @param sip 套接字地址
     */
    private static InetSocketAddress sip;
    /**
     * @param keys 临时key集合
     */
    private SelectionKey[] tempKey;
    /**
     * @param selector 客户机监听器
     */
    private Selector selector;
    /**
     * @param
     */
    private SocketChannel client;
    /**
     * @param
     */
    private ForkJoinPool pool;
    /**
     * @param charset 字符集
     */
    private Charset charset = Charset.forName("utf-8");
    /**
     * 隐藏构造器
     */
    private Client() {}
    public void client() throws IOException {
        try {
            //打开一个监听器
            selector = Selector.open();
            //创建SocketChannel
            client = SocketChannel.open(sip);
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
            //创建一个线程池----利用多核CPU异步处理
            pool = ForkJoinPool.commonPool();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //启动监听线程
        new Thread(() -> {
            try {
                while(selector.select() > 0) {
                    Set<SelectionKey> keys = selector.selectedKeys();
                    //转为数组
                    SelectionKey[] keyArr = keys.toArray(SelectionKey[]::new);
                    //拷贝一份
                    Arrays.copyOf(keyArr, keyArr.length);
                    //删除集合中元素
                    keys.removeAll(keys);
                    //提交任务
                    pool.submit(new Task(tempKey));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();

        //用户发送信息
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        try {
            while(!sc.hasNext("exit")) {
                client.write(charset.encode(sc.next()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //客户机退出 关闭资源
            client.close();
            selector.close();
        }
    }

    private class Task extends RecursiveAction {
        SelectionKey[] keys;
        private Task(SelectionKey[] keys) {
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
                        Client.Task task1 = new Client.Task(Arrays.copyOfRange(keys, 0, keys.length / 2));
                        Client.Task task2 = new Client.Task(Arrays.copyOfRange(keys, keys.length / 2, keys.length));
                        task1.fork();
                        task2.fork();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        private void isThings(SelectionKey key)
                throws IOException {
            if(key.isReadable()) {
                String s = "";
                SocketChannel sc = (SocketChannel)key.channel();
                ByteBuffer buff = ByteBuffer.allocate(1024);
                while(sc.read(buff) > 0) {
                    buff.flip();
                    s += charset.decode(buff);
                }
                System.out.println(s);
                //为下一次准备
                key.interestOps(SelectionKey.OP_READ);
            }
        }
    }

    public static Client start(String ip) {
        try {
            //初始化程序配置
            String[] field = ip.split("\\.");
            byte[] bytes = new byte[field.length];
            for (int i = 0; i < field.length; i++) {
                bytes[i] = Integer.valueOf(field[i]).byteValue();
            }
            sip = new InetSocketAddress(InetAddress.getByAddress(bytes), PORT);
            return new Client();
        } catch(Throwable e) {
            //服务器端程序初始化失败
            e.printStackTrace();
            return null;
        }
    }

}

class StartClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        System.out.print("是否进入聊天室 [y/n]:");

        try {
            while(sc.hasNext("[yn]")) {
                if(sc.next().equals("y")) {
                    Client.start("112.74.50.86").client();
                }
                else {
                    System.out.println("程序两秒后退出...");
                    Thread.sleep(2*1000);
                    System.exit(0);
                }
            }

        } catch (IOException e) {
            System.err.println("客户机退出异常");
            System.exit(-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}