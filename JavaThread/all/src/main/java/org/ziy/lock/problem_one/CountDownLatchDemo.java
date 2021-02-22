package org.ziy.lock.problem_one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/18
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(5);
        new Thread(() -> {
            boolean flag = false;
            for (int i = 0; i <10; i++) {
                list.add(new Object());
                System.out.println(list.size());
                latch.countDown();

                if(latch.getCount() == 0 && !flag) {
                    try {
                        Thread.sleep(2000);
                        flag = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();
        new Thread(() -> {
            try {
                latch.await();
                System.out.println("释放");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(list.size() == 5) {
                System.out.println("提示");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("size = "+list.size());
            }
            System.out.println("结束");
        }).start();
    }
}
