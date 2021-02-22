package org.ziy.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/14
 */
public class CountDownLatch_demo {
    static Thread[] threads = new Thread[100];
    static CountDownLatch latch = new CountDownLatch(threads.length);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                m();
            });
        }

        //运行线程
        for (Thread thread : threads) {
            thread.start();
        }
        //让main线程等待
        latch.await();
        System.out.println("main end");
    }
    public static synchronized void m() {
        System.out.println(Thread.currentThread().getName()+"    start");
        try {
            Thread.sleep(100);
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +"    end");
    }
}
