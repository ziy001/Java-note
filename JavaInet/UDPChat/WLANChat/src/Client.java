import java.io.IOException;
import java.net.MulticastSocket;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/6/24 20:24
 */
public class Client {
    public static void main(String[] args) {
        try {
            //创建一个 Multi castSocket
            MulticastSocket socket = new MulticastSocket(5900);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
