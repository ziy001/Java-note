package org.ziy.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/14
 */
public class CyclicBarrier_Demo {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("满人，发车"));

        for (int i = 0; i <100; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "  start");
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
//        Thread.sleep(10000);

    }
}
