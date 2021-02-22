package org.ziy.volatileDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/13
 */
public class Demo2 implements Runnable {
//    private static volatile int i = 0;
    private static AtomicInteger v = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            list.add(new Thread(new Demo2()));
        }

        list.forEach(Thread::start);
    }
    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            //使用原子类进行自增 -- 底层使用CAS无锁优化
            v.incrementAndGet();
        }
        System.out.println(v.get());
    }
}
