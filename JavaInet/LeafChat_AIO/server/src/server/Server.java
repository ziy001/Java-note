package server;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/6/17 16:34
 * TODO:基于AIO的网络通信
 */
public class Server {
    /**
     * 端口号
     */
    private static final int PORT = 5900;
    /**
     *  字符串类型IP
     */
    private final String ip;
    public Server(String ip) {
        this.ip = ip;
    }
    /**
     * 程序入口
     * @throws IOException 服务器程序绑定时出错
     */
    public void server() throws IOException {
        //创建一个 线程池
        //线程数
        final int size = 20;
        ThreadPoolExecutor pool = new ThreadPoolExecutor(size, size,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),(r) -> new Thread(r, "ziy-Thread"));
        //用执行线程池创建一个Group
        AsynchronousChannelGroup group = AsynchronousChannelGroup.withThreadPool(pool);
        //使用线程创建一个
        //对ip地址进行处理并创建ip/port对象让本机绑定
        String[] split = this.ip.split("\\.");
        byte[] bytes = new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            bytes[i] = Integer.valueOf(split[i]).byteValue();
        }
        //创建并绑定
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(group)
                .bind(new InetSocketAddress(InetAddress.getByAddress(bytes),PORT));
        System.out.println("服务开始运行....");
        System.out.println("ip/port: "+ server.getLocalAddress());
        server.accept(null, new AcceptHandler(server));
        //保持程序存活
        //使用accept将OP_ACCEPT操作交给异步进行处理，本线程继续运行
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        while(!sc.hasNext("exit")) {}
        //完成关闭程序
        server.close();
        pool.shutdown();
    }
}
class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
    /**
     * 解编码的字符集
     */
    private static final Charset charset = Charset.forName("utf-8");
    /**
     * ServerSocketChannel
     */
    private AsynchronousServerSocketChannel server;
    /**
     * 用于数据的读取
     */
    private final ByteBuffer buff = ByteBuffer.allocate(2048);
    /**
     * 用于保存当前连接到服务器上的客户端SocketChannel和ip地址
     */
    private static final HashMap<AsynchronousSocketChannel, String> userMap = new HashMap<>(50);

    /**
     * 用于服务器端日志记录
     */
    private File fileMsg = new File("Msg");

    /**
     * 构造器初始化实例
     * @param server 传入服务器端SocketChannel
     * @throws IOException 文件创建失败
     */
    public AcceptHandler(AsynchronousServerSocketChannel server)
            throws IOException {
        this.server = server;
        //对文件进行检查
        if(!fileMsg.exists()) {
            fileMsg.createNewFile();
        }
    }

    /**
     * 当系统底层将ACCEPT操作好以后，触发该功能并返回操作完后的对象
     * @param client 监听操作后返回的连接的值
     * @param attachment 附加值
     */
    @Override
    public void completed(AsynchronousSocketChannel client, Object attachment) {
        //获取该客户端的ip/port
        String ipName = "";
        try {
            ipName = client.getRemoteAddress().toString();
            ipName = ipName.substring(0, ipName.indexOf(":"));
        } catch (IOException e) {
            ipName = "default";
        }
        //添加到userMap
        userMap.put(client, ipName);
        //对连接成功信息进行分别处理
        log(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())
                +"     : "+ ipName +" 上线了!!!", true);
        final String finalIpPort = ipName;
        //准备下一个连接
        //注释掉该段代码。会导致程序能够处理连接，但是返回SocketChannel以后没有程序去消费，导致只能连接无法后续操作
        server.accept(null, this);

        client.read(buff, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer length, Object attachment) {
                //准备读写
                buff.flip();
                String s = charset.decode(buff).toString();
                //对信息进行格式处理
                s = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now())
                        + userMap.get(client) + "     : " + s;

                //将读取的数据广播到所有客户端
                log(s, true);
                //为下一次读写做好准备
                buff.clear();
                //继续进行下一次
                client.read(buff, null, this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                //广播并写入消息记录文件中
                log(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())
                        +"     : "+ finalIpPort +" 下线了!!!", true);
                //从集合中删掉
                userMap.remove(client);
                buff.clear();
            }
        });
    }

    private void broad(String msg) {
        for (AsynchronousSocketChannel c : userMap.keySet()) {
            c.write(charset.encode(msg));
        }
    }

    private void log(String msg, boolean broad) {
        if(!"".equals(msg)) {
            try(PrintWriter pw = new PrintWriter(new FileOutputStream(fileMsg, true))) {
                pw.println(msg);
            } catch (FileNotFoundException e) {
                System.out.println("消息记录文件丢失");
            }
            if(broad) {
                broad(msg);
            }
        }
    }

    /**
     *
     * @param exc  异常对象
     * @param attachment 附加值
     */
    @Override
    public void failed(Throwable exc, Object attachment) {
        System.out.println("连接失败: "+ exc.getMessage());
    }
}