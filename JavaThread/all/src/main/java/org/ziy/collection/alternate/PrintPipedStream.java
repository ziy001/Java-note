package org.ziy.collection.alternate;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/30
 * TODO:交替打印 之 线程管道通信
 */
public class PrintPipedStream {

    public static void main(String[] args) throws IOException {
        PipedInputStream threadOneIn = new PipedInputStream();
        PipedInputStream threadTwoIn = new PipedInputStream();
        PipedOutputStream threadOneOut = new PipedOutputStream();
        PipedOutputStream threadTwoOut = new PipedOutputStream();

        //建立连接
        threadOneIn.connect(threadTwoOut);
        threadTwoIn.connect(threadOneOut);
        final String s = "coffee baby";
        new Thread(() -> {
            byte[] bytes = new byte[1024];
            try {
                for (int i = 1; i < 27; i++) {
                    threadOneOut.write(s.getBytes());
                    System.out.println(i);
                    //向线程2写入数据
                    threadOneIn.read(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(() -> {
            byte[] bytes = new byte[1024];
            try {
                for (char c = 'A'; c <= 'Z'; c++) {
                    threadTwoIn.read(bytes);
                    System.out.println(c);
                    threadTwoOut.write(s.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
