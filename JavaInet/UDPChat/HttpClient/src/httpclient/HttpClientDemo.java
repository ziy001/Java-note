package httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.time.Duration;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/6/27 9:25
 */
public class HttpClientDemo {
    public static void main(String[] args)
            throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.cxhhmy.com/"))
                .header("Content-Type", "text/html")
                .timeout(Duration.ofSeconds(10))
                .build();
        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString(Charset.forName("UTF-8"));
        //发送请求得到响应体
        //同步发送
        HttpResponse<String> response = client.send(request, handler);
        //异步发送
//        client
        //获取响应体中相关数据
        System.out.println("响应状态: \n"+ response.statusCode());
        System.out.println("响应头: \n"+ response.headers());
        System.out.println("响应体: \n"+ response.body());
    }
}
