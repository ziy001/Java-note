package org.ziy.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/18
 */
public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if(i == 3) {
                    LockSupport.park();
                }
                if(i == 7) {
                    LockSupport.park();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        });

        t.start();
        LockSupport.unpark(t);
        Thread.sleep(15000);
        LockSupport.unpark(t);

    }
}
