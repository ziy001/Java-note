package org.ziy.collection.alternate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/30
 * TODO:交替打印 原子包优化CAS
 */
public class PrintAtomic {
    private static AtomicInteger threadNo = new AtomicInteger(1);
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 1; i < 27; i++) {
                while(threadNo.get() != 1) {}
                System.out.println(i);
                //原子性操作不会被打断
                threadNo.set(2);
            }
        }).start();

        new Thread(() -> {
            for (char c = 'A'; c <= 'Z'; c++) {
                while(threadNo.get() != 2) {}
                System.out.println(c);
                threadNo.set(1);
            }
        }).start();
    }
}
