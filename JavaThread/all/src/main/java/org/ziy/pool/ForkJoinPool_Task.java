package org.ziy.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author ziy
 * @version 1.0
 * @date 下午8:19 2020/11/8
 * @description TODO:执行有返回值的任务,计算1到1000000的中偶数和
 * @className ForkJoinPool_Task
 */
public class ForkJoinPool_Task {
    public static void main(String[] args) {
        resTask resTask = new resTask(0, 1000000);
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = pool.submit(resTask);
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
    static class resTask extends RecursiveTask<Integer> {
        private int start = 0;
        private int end = 0;

        public resTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if(end - start <= 100000) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    if(i % 2 == 0) {
                        sum += i;
                    }
                }
                return sum;
            }
            else {
                int middle = (end - start) / 2;
                resTask t1 = new resTask(start, middle);
                resTask t2 = new resTask(middle + 1, end);
                //fork
                t1.fork();
                t2.fork();
                //join
                return t1.join()+t2.join();
            }
        }
    }
}
