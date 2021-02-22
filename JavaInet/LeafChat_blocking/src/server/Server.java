package server;

import java.net.InetAddress;
import java.util.Arrays;

/**
 * @Author ziy
 * @Date 2020/6/11 10:03
 * @Version 1.0
 * TODO:服务器的主程序的实现
 */
public class Server {
    /**
     * @param port 通信的端口号
     */
    private int port;
    /**
     * @param ip 通信的IP地址
     */
    private InetAddress ip;

    public Server(String ip, int port) {
        init(ip, port);
    }

    /**
     * 完成类的初始化操作
     * @param ip
     * @param port
     * @return
     */
    private boolean init(String ip, int port) {
        //对字符串形式的ip转换为可用形式
        final String[] field = ip.split("\\.");
        byte[] Byte = new byte[field.length];
        for (int i = 0; i < field.length; i++) {
            Byte[i] = java.lang.Byte.valueOf(field[i]);
        }
        return false;
    }

}
