package org.ziy.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/14
 */
public class Demo1 {
    public static void main(String[] args) {
        Demo1 d = new Demo1();
        //尝试锁Test
//        d.tryLockTest();
        d.lockInTest();
    }
    public void tryLockTest() {
        final ReentrantLock lock = new ReentrantLock();
        System.out.println("Test");
        //启用一个线程
        new Thread(() -> {
            //上锁
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+" start");
                Thread.sleep(10 * 1000);
                System.out.println(Thread.currentThread().getName()+" end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            boolean b = false;
            try {
                System.out.println(Thread.currentThread().getName()+" start");
                b = lock.tryLock(5, TimeUnit.SECONDS);
                System.out.println("后续代码");
                if(b) {
                    System.out.println("得到锁");
                }
                System.out.println(Thread.currentThread().getName()+" end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(b);
                if(b) {
                    lock.unlock();
                }
            }
        }).start();
    }

    public void lockInTest() {
        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            try {
                lock.lockInterruptibly();
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+" "+i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
//                lock.unlock();
            }

        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(500);
                Thread.interrupted();
                System.out.println("获得锁");
                for (int i = 0; i <100; i++) {
                    Thread.sleep(100);
                    if(i == 50) {
                        Thread.sleep(500);
                    }
                    System.out.println(Thread.currentThread().getName() + "   " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void fairTest() {
        ReentrantLock lock = new ReentrantLock(true);
    }
}
