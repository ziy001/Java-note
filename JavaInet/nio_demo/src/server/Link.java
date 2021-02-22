package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.http.HttpClient;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/21
 * TODO:服务端主程序
 */
public class Link {
    public void open() throws IOException {
        //创建多路复用器
        Selector selector = Selector.open();
        //打开服务端SocketChannel
        ServerSocketChannel channel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("localhost", 5900);
        channel.bind(address);
        //注册到多路复用器
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_ACCEPT);

        while(selector.select() > 0) {
            //获取正在发生的兴趣集
            Set<SelectionKey> keys = selector.selectedKeys();
            for (SelectionKey key : keys) {
                if(key.isAcceptable()) {
                   //
                }
            }
        }
        HttpClient
    }
}
