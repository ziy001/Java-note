package test;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Properties;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/6/22 17:33
 * TODO:测试学习类
 */
public class MainTest {
    public static void main(String[] args)
            throws SocketException {
//        NetworkInterface.networkInterfaces()
//                .iterator().forEachRemaining((e) -> {
//            try {
//                System.out.println(e+"  运行状态:"+e.isUp());
//            } catch (SocketException socketException) {
//                socketException.printStackTrace();
//            }
//        });
        Properties prop = System.getProperties();
        System.out.println(prop);
    }
}
