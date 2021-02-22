package org.ziy.lock.problem_one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/18
 */
public class LockSupport_WithoutSleep {
    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {
        List list = new ArrayList();

        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add(new Object());
                System.out.println(i);
                if(list.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        });
        t2 = new Thread(() -> {
            LockSupport.park();
            if(list.size() == 5) {
                System.out.println("提示");
            }
            System.out.println("结束");
            LockSupport.unpark(t1);
        });
        t1.start();
        t2.start();
    }
}
