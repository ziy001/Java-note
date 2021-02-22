package test;

import java.io.IOException;
import java.net.*;
import java.nio.charset.Charset;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/6/22 17:37
 */
public class Server {
    /**
     * 端口号
     */
    private static final int PORT = 5900;

    public void server() {
        //创建一个DatagramSocket
        try {
            DatagramSocket socket = new DatagramSocket(5900);
            String msg = "发送的数据:01001";
            //创建一个可发送的数据报
            DatagramPacket packet = new DatagramPacket(msg.getBytes(Charset.forName("utf-8")), msg.length(),
                    InetAddress.getByName("192.168.1.177"), PORT);
            socket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
