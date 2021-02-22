package org.ziy.collection.alternate;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/30
 * TODO:交替打印 1 A 2 B 3 C ...
 */
public class AlternatePrint {
    private static final Object o = new Object();
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (o) {
                for (int i = 1; i < 27; i++) {
                    System.out.println(i);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //唤醒所有线程结束
                o.notify();
            }

        }).start();
        new Thread(() -> {
            for (char c = 'A'; c <= 'Z'; c++) {
                synchronized (o) {
                    System.out.println(c);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
