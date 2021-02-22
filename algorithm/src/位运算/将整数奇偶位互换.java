package 位运算;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午12:48 2020/11/29
 * @description TODO:将整数的二进制形式上的奇偶位进行互换
 * @className 将整数奇偶位互换
 */
public class 将整数奇偶位互换 {
    //101010...10
    private static final int X = 0Xaaaaaaaa;
    //010101...01
    private static final int Y = 0X55555555;

    public static void main(String[] args) {
        int num = 720;
        System.out.println("原二进制: " + Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(test1(num)));
    }

    private static int test1(int num) {
        // 保留奇数位
        int x = num & X;
        // 保留偶数位
        int y = num & Y;
        int i = (x >>> 1) ^ (y << 1);
        return i;
    }
}
