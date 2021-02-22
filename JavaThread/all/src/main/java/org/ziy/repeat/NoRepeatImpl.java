package org.ziy.repeat;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/11
 * TODO:不可重入锁的实现
 */
public class NoRepeatImpl {
    private boolean isLocked = false;
    public synchronized void lock() throws InterruptedException{
        while(isLocked){
            wait();
        }
        isLocked = true;
    }
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}
