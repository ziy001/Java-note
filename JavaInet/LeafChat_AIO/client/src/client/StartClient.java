package client;

import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/6/20 13:28
 */
public class StartClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        System.out.print("Remote IP: ");
        while(sc.hasNext()) {
            String ip = sc.next();
            ip = ip.strip();
            if(Pattern.matches("((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}", ip)) {
                try {
                    new Client(ip, 5900).client();
                } catch (UnknownHostException e) {
                    System.out.println("请检查网络连接以后 重试....");
                    System.out.print("Remote IP: ");
                    continue;
                }
                break;
            }
            else {
                System.out.println("请输入正确的ip地址");
                System.out.print("Remote IP: ");
            }
        }

    }
}
