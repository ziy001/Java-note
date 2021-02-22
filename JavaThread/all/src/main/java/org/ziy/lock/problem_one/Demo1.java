package org.ziy.lock.problem_one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/18
 * TODO: 一个线程往容器里面添加元素，当达到5个元素线程2提示并结束
 */
public class Demo1 {
    public static void main(String[] args) {
        List list = new ArrayList(10);
        final Object obj = new Object();
        new Thread(() -> {
            synchronized (obj) {
                for (int i = 0; i < 10; i++) {
                    list.add(new Object());
                    System.out.println(list.size());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(list.size() == 5) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            obj.notify();
                        }
                    }
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (obj) {
                try {
                    if(list.size() == 5) {
                        System.out.println("t2 提示");
                    }
                    else {
                        obj.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("t2 结束");
                    obj.notify();
                }
            }
        }).start();
    }
}
