package org.ziy.threadlocal;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/25
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<Integer> local = new ThreadLocal<Integer>();
        local.set(99);
        new Thread(() -> {
            local.set(100);
        }).start();
        new Thread(() -> {
            Integer integer = local.get();
            System.out.println(integer);
        }
        ).start();
        System.out.println(local.get());
    }
}
