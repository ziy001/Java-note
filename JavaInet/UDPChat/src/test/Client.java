package test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/6/22 17:37
 */
public class Client {
    /**
     * 端口号
     */
    private static final int PORT = 5900;
    /**
     * 定义接受一次数据报最大容量
     */
    private static final int MAX_SIZE = 4096;
    /**
     * 数据存储
     */
    private static final byte[] data = new byte[MAX_SIZE];
    public void client() {
        try {
            DatagramSocket socket = new DatagramSocket(5900);
            socket.receive(new DatagramPacket(data, data.length));
            String s = Arrays.toString(data);
            System.out.println(s);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("数据读取失败");
        }
    }
}
