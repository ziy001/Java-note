package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/6/17 16:35
 */
public class Client {
    /**
     * ip/port
     */
    private final SocketAddress address;
    /**
     * 本机的SocketChannel
     */
    private AsynchronousSocketChannel client;

    /**
     * 存放读取数据
     */
    private final ByteBuffer buff = ByteBuffer.allocate(2048);

    /**
     *  编解码的字符集
     */
    private static final Charset charset = Charset.forName("utf-8");

    /**
     *  扫描仪
     */
    private static final Scanner sc = new Scanner(System.in);

    /**
     * 初始化程序
     * @param ip 用户需要输入的ip地址
     * @param port 远程服务器的端口号
     * @throws UnknownHostException 当本机网络不可用时抛出该异常
     */
    public Client(String ip, int port)
            throws UnknownHostException {
        this.address = init(ip, port);
        this.sc.useDelimiter("\n");
    }
    private SocketAddress init(String ip, int port)
            throws UnknownHostException {
        String[] split = ip.split("\\.");
        byte[] bytes = new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            bytes[i] = Integer.valueOf(split[i]).byteValue();
        }
        return new InetSocketAddress(InetAddress.getByAddress(bytes), port);
    }

    /**
     * 主程序
     * 负责服务器的连接工作
     * 将read操作进行异步处理
     * 退出程序
     */
    public void client() {
        //进行服务器的连接
        try {
            //打开一个SocketChannel并连接到指定远程服务器
            client = AsynchronousSocketChannel.open();
            //使用get()方法等待异步IO处理完成后返回
            client.connect(address).get(10, TimeUnit.SECONDS);
            System.out.println("服务器连接成功");
        } catch (Throwable e) {
            System.out.print("连接到服务器失败");
            System.out.println(",请检查网络是否畅通");
            System.exit(1);
        }
        //将read操作进行异步操作
        client.read(buff, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer length, Object attachment) {
                //拿出buff中内容
                buff.flip();
                String s = charset.decode(buff).toString();
                System.out.println(s);
                buff.clear();
                //继续下一次的读取
                client.read(buff, null, this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                //通常情况下是服务器被关闭
                System.out.println("服务器已关闭，立马退出程序");
                buff.clear();
                System.exit(0);
            }
        });
        //客户机退出程序
        String s = "";
        while(!sc.hasNext("exit")) {
            s = sc.next();
            //过滤空白信息
            if(!":q".equals(s)) {
                ByteBuffer buff = charset.encode(s.toString());
                client.write(buff);
            }
            else {
                System.out.println("输入信息不能为空");
            }
        }
        //关闭资源
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
