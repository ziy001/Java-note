package org.ziy.lock;

import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/14
 * TODO:模拟婚礼过程 只有当所有人到达以后才能通行
 */
public class Phaser_Demo {
    static ThreadLocalRandom random = ThreadLocalRandom.current();
    static Phaser phaser = new PhaserImpl();
    public static void main(String[] args) {
        //设置栅栏线程个数
        phaser.bulkRegister(7);
        String[] names = {"张三", "李四", "王五", "赵六", "翠花"};
        Thread[] threads = new Thread[names.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Person(names[i]), names[i]);
            threads[i].start();
        }
        //新郎 新娘开始进场
        new Thread(new Person("新娘")).start();
        new Thread(new Person("新郎")).start();

    }
    static class Person implements Runnable {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            arrive();
            eat();
            leave();
            hug();
            test();
        }

        private void arrive() {
            sleep(random.nextInt(1000));
            System.out.println(name+"  到达");
            phaser.arriveAndAwaitAdvance();

        }
        private void eat() {
            sleep(random.nextInt(1000));
            System.out.println(name+"  吃饭");
            phaser.arriveAndAwaitAdvance();

        }
        private void leave() {
            sleep(random.nextInt(1000));
            System.out.println(name+"  离开");
            phaser.arriveAndAwaitAdvance();

        }
        private void hug() {
            if(name.equals("新郎") || name.equals("新娘")) {
                sleep(random.nextInt(1000));
                System.out.println(name+"  洞房");
                phaser.arriveAndAwaitAdvance();
            }
            else {
                phaser.arriveAndDeregister();
            }
        }
        private void test() {
            System.out.println("注销线程执行了剩余代码");
        }

        private void sleep(int ms) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class PhaserImpl extends Phaser {
        /**
         *
         * @param phase 栅栏序号
         * @param registeredParties 注册的线程数
         * @return 当返回true时表示整个栅栏组就结束了
         */
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人到齐了  " + registeredParties);
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("所有人吃完了  " + registeredParties);
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("所有人离开了  " + registeredParties);
                    System.out.println();
                    return false;
                case 3:
                    System.out.println("婚礼结束，新娘新郎结束  " + registeredParties);
                    System.out.println();
                    
//                    return true;
                    return false;
                case 4:
                    System.out.println("最后的栅栏被推翻了");
                    System.out.println();
                    return true;
                default:
                    return true;
            }
        }
    }
}
