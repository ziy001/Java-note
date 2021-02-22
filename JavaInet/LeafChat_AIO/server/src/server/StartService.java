package server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/6/20 13:26
 */
public class StartService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("服务器IP: ");
        while(sc.hasNext()) {
            String ip = sc.next();
            ip = ip.strip();
            if(Pattern.matches("((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}", ip)) {
                try {
                    new Server(ip).server();
                } catch (IOException e) {
                    System.out.println("程序无法绑定或记录文件创建失败");
                    System.exit(-1);
                }

                break;
            }
            else {
                System.out.println("请输入正确的ip地址");
                System.out.print("服务器IP: ");
            }
        }

    }
}
