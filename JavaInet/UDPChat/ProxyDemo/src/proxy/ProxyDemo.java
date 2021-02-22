package proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/6/26 8:46
 */
public class ProxyDemo {
    private final String IP = "211.137.52.158";
    private final int PORT = 8080;
    private final URL url;

    public ProxyDemo()
            throws MalformedURLException {
        url =  new URL("http://u12542256.viewer.maka.im/k/A3JY6CPCW12542256?t=1593223199260");
    }

    public static void main(String[] args)
            throws IOException {
        new ProxyDemo().simpleUse();
    }

    /**
     * 代理服务器的简单使用
     */
    private void simpleUse()
            throws IOException {
        //创建代理服务器对象
        InetSocketAddress address = new InetSocketAddress(IP, PORT);
        System.out.println("代理服务器的IP/PORT"+ address);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, address);
        //使用代理服务器打开连接
        URLConnection conn = url.openConnection(proxy);
        conn.setConnectTimeout(20*1000);
//        URLConnection conn = url.openConnection();
        //设置请求头字段
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.116 Safari/537.36");
        //获取网页输入流
        InputStream is = conn.getInputStream();
        String s = "";
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(is)) ) {
            while((s = br.readLine()) != null) {
                System.out.println(s);
            }
        }
    }
}
