package org.ziy.lock.problem_two;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/18
 * TODO: put方法容器已满就阻塞等待，get()当容器为空阻塞等待
 */
public class Container<T> {
    private static final int MAX_COUNT = 10;
    private int count;
    private final int initSize;
    private List<T> list;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition consumer = lock.newCondition();
    private final Condition provider = lock.newCondition();



    public Container(int initSize) {
        this.initSize = initSize;
        this.list = new ArrayList<>(initSize);
        this.count = list.size();
    }
    public Container() {
        this(MAX_COUNT);
    }

    public void put(T value) {
        try {
            lock.lock();
            if(count < initSize) {
                list.add(value);
                count = list.size();
            }
            else {
                //通知消费者线程运行
                consumer.signalAll();
                //阻塞线程,放开锁
                provider.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public T get(int index) {
//        AbstractQueuedSynchronizer
        T result = null;
        try {
            lock.lock();
            //需要使用while，让线程运行之后再次判断
            if((count - 1) > 0) {
                result = list.remove(index);
                count = list.size();
            }
            else {
                //通知生产者线程运行
                provider.signalAll();
                // 阻塞，释放锁
                consumer.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return result;
    }
    public int getCount() {
        return count;
    }
}
