package org.ziy.collection.alternate;

import java.util.concurrent.Exchanger;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/30
 */
public class PrintExchaner {
    public static void main(String[] args) {
        Exchanger<Byte> ex = new Exchanger<>();

        new Thread(() -> {
            byte b = 1;
            try {
                for (int i = 1; i < 27; i++) {
                    ex.exchange(b);
                    System.out.println(i);
                    ex.exchange(b);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            byte b = 1;
            try{
                for(char c='A'; c <= 'Z'; c++) {
                    ex.exchange(b);
                    ex.exchange(b);
                    System.out.println(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
