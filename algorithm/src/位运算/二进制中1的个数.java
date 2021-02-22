package 位运算;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午9:13 2020/11/29
 * @description TODO:找出一个十进制整数的二进制形式中的1的个数,int型是32位 long型是64位
 * @className 二进制中1的个数
 */
public class 二进制中1的个数 {
    public static void main(String[] args) {
        int i = 1000;
        String s = Integer.toBinaryString(i);
        System.out.println("二进制: " + s);
        System.out.println(test1(i));
        System.out.println(test2(i));
    }
    private static int test1(int i) {
        int count = 0;
        for (int j = 0; j < 32; j++) {
            i = i >>> 1;
            boolean b = (1 & i) == 1;
            if (b) {
                count++;
            }
        }
        return count;
    }

    /**
     * 使用 (x - 1) & x 这个公式，每次执行都可以消除x中的低位1，当该公式结果 = 0时就结束
     * @param i
     * @return
     */
    private static int test2(int i) {
        int count = 0;
        while (i != 0) {
            i = (i - 1) & i;
            count++;
        }
        return count;
    }
}
