package org.ziy.repeat;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/11
 * TODO:实现可重入锁
 */
public class RepeatImpl {
    /**
     * 锁状态
     */
    boolean isLocked = false;
    /**
     * 线程
     */
    Thread  lockedBy = null;
    /**
     * 记录锁的个数
     */
    int lockedCount = 0;

    /**
     * 上锁方法
     * @throws InterruptedException
     */
    public synchronized void lock()
            throws InterruptedException{
        //获取当前执行线程
        Thread thread = Thread.currentThread();

        while(isLocked && lockedBy != thread){
            //锁状态-true 线程不是当前执行线程
            //判断这个锁是不是当前线程在获取
            //不是就 等待
            wait();
        }
        //当前线程在再次获取锁
        isLocked = true;
        //计数器++
        lockedCount++;
        //线程为当前线程
        lockedBy = thread;
    }

    /**
     * 解锁方法
     */
    public synchronized void unlock(){
        if(Thread.currentThread() == this.lockedBy){
            lockedCount--;
            if(lockedCount == 0){
                isLocked = false;
                notify();
            }
        }
    }
}
