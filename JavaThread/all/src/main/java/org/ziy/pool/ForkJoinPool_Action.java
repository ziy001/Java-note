package org.ziy.pool;

import java.io.IOException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author ziy
 * @version 1.0
 * @date 下午1:45 2020/11/8
 * @description TODO:无返回值的任务，打印50个数
 * @className ForkJoinPool_Action
 */
public class ForkJoinPool_Action {
    private static final int MAX = 10;

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new Task(0, 50));
        //战术阻塞
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 定义任务类
      */
    static class Task extends RecursiveAction {
        private int start = 0;
        private int end = 0;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if(end - start <= 10) {
                //打印
                for (int i = start; i <= end; i++) {
                    System.out.println(Thread.currentThread().getName()+" -> "+i);
                }
            }
            else {
                //计算middle值
                int middle = (end + start) / 2;
                Task t1 = new Task(start, middle);
                Task t2 = new Task(middle + 1, end);
                //将这两个对象进行fork
                t1.fork();
                t2.fork();
            }
        }
    }
}
