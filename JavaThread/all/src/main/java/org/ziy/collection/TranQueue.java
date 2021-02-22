package org.ziy.collection;

import java.util.concurrent.*;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/29
 * TODO:TransferQueue的示范程序
 */
public class TranQueue {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(20, 20,
                        0, TimeUnit.SECONDS,
                new ArrayBlockingQueue(10),
                Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.DiscardPolicy());
        LinkedTransferQueue<Object> queue = new LinkedTransferQueue<>();
        Object[] objs = new Object[15];
        for (int i = 0; i < objs.length; i++) {
            objs[i] = new Object();
        }
        //异步启动一系列的生产者线程
        //创建15个生产者线程
        for (int i = 0; i < 15; i++) {
            final int finalI = i;
            pool.submit(() -> {
                try {
                    queue.transfer(objs[finalI]);
                    System.out.println(objs[finalI]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("生产者线程开启完毕");
        Thread.sleep(1000);
        //启动消费者线程,取出
        /*
        证明了
            1.transfer()方法只要监视到自己存入的那个对象被移除queue就算是被消费
            2.移除方法可以是remove等系列方法
         */
        queue.remove(objs[4]);

    }
}
