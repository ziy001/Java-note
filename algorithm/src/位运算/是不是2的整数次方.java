package 位运算;

import java.util.Random;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午10:09 2020/11/29
 * @description TODO:
 * @className 是不是2的整数次方
 */
public class 是不是2的整数次方 {
    public static void main(String[] args) {
        int num = new Random().nextInt();
//        int num = 10;
        System.out.println("num: " + num);
        System.out.println(test1(num));
    }

    private static boolean test1(int num) {
        int count = 0;
        while (num != 0) {
            num = (num - 1) & num;
            count++;
            if(count > 1) {
                return false;
            }
        }
        if (count != 1) {
            return false;
        }
        return true;
    }
}
