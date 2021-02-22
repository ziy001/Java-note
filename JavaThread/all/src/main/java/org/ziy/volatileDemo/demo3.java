package org.ziy.volatileDemo;

/**
 * @author ziy
 * @version 1.0
 * @date 上午10:40 2020/11/8
 * @description TODO:禁止指令重排序
 * @className demo3
 */
public class demo3 {
    /**
     * 状态
     */
    volatile static boolean flag = false;
    public static void main(String[] args) {
        //模拟A线程 对文件的读取配置
        Thread a = new Thread(() -> {
            System.out.print("1 ");
            System.out.println("2");
            flag = true;
        });
        //模拟B线程 获取A线程配置的对象进行后续操作
        Thread b = new Thread(() -> {
            while(flag) {
                System.out.println("运行B");
                flag = false;
            }
        });

        //让上面模拟运行10000
        for (int i = 0; i < 1000; i++) {
            a.start();
            b.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
