package org.ziy.collection;

import java.util.concurrent.SynchronousQueue;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/29
 * TODO：交替打印
 */
public class SyncQueue {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Character> queue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                while(true) {

                    System.out.println(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        int i = 1;
        for (char c = 'a'; c <= 'z';) {
            System.out.println(i);
            queue.put(c);
            c++;
            i++;
            Thread.sleep(1);
        }

    }
}
