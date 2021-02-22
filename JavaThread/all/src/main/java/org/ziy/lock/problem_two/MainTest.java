package org.ziy.lock.problem_two;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/18
 * TODO:写一个固定容量的同步容器,支持get()和put()并且有getCount()，支持2个生产线程和10个消费线程的阻塞调用
 */
public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        Container<Integer> container = new Container<>();
        Thread[] putThreads = new Thread[2];
        Thread[] getThreads = new Thread[10];

        //初始化
        for (int i = 0; i < putThreads.length; i++) {
            putThreads[i] = new Thread(() -> {
                System.out.println("生产者线程运行...");
                container.put(10);
            });
        }
        for (int i = 0; i < getThreads.length; i++) {
            getThreads[i] = new Thread(() -> {
                System.out.println("消费者线程运行...");
                Integer result = container.get(0);
                System.out.println(result);
            });
        }

        for (Thread putThread : putThreads) {
            Thread.sleep(1000);
            putThread.start();
        }
        for (Thread getThread : getThreads) {
            Thread.sleep(1000);
            getThread.start();
        }
    }
}
