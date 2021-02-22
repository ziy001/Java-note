package org.ziy.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/27
 */
public class Demo1 {
    public static void main(String[] args) {
        Comparator c = new Comparator<>() {

            @Override
            public int compare(Object o1, Object o2) {
                if(!(o1 instanceof MyTask && o2 instanceof MyTask)) {
                    throw new ClassCastException();
                }
                int a = ((MyTask) o1).i;
                int b = ((MyTask) o2).i;
                return a > b?1:a == b?0:-1;
            }
        };
        TreeSet<MyTask> myTask = new TreeSet<>(c);
//        DelayQueue myTask = new DelayQueue
        Random r = new Random();

        MyTask[] myTasks = new MyTask[5];
        for (int i = 0; i < myTasks.length; i++) {
            myTasks[i] = new MyTask(r.nextInt(1000));
        }
        for (MyTask task : myTasks) {
            myTask.add(task);
        }


        myTask.forEach((o) -> {
            System.out.println(o.i);
        });
    }
}
