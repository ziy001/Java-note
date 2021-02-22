package org.ziy.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/17
 */
public class ReadWriteLock_Demo {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Lock readLock = lock.readLock();
        Lock writeLock = lock.writeLock();
        //启动18个线程来读数据
        for (int i = 0; i < 18; i++) {
            new Thread(() -> {
                read(readLock);
            }).start();
        }
        //启动5个写线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                write(writeLock);
            }).start();
        }
    }
    public static void read(Lock lock) {
        try{
            lock.lock();
            sleep(500);
            //模拟读取
            System.out.println("read over");
        } finally {
            lock.unlock();
        }


    }
    public static void write(Lock lock) {
        try{
            lock.lock();
            sleep(1000);
            //模拟写操作
            System.out.println("write over");
        }finally {
            lock.unlock();
        }

    }
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
