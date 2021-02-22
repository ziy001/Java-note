package org.ziy.collection.alternate;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/30
 * TODO:交替打印的CAS无锁优化
 */
public class PrintCas {

    enum RunThread{T1, T2}

    /**
     * 使用volatile 禁止指令重排序
     */
    private static volatile RunThread thread;

    public static void main(String[] args) {
        new Thread(() -> {
            //两个线程竞争获取锁
            thread = RunThread.T1;

            for (int i = 1; i < 27; i++) {
                //当前线程自旋等待获取锁
                while(thread != RunThread.T1) {}
                System.out.println(i);
                //将锁让给线程2
                thread = RunThread.T2;
            }

        }).start();
        new Thread(() -> {
            //竞争
            thread = RunThread.T2;

            for (char c = 'A'; c <= 'Z'; c++) {
                while(thread != RunThread.T2) {}
                System.out.println(c);
                thread = RunThread.T1;
            }
        }).start();
    }
}
