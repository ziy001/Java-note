package 递归;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午8:53 2020/11/30
 * @description TODO:求fib的指定位的数值   f(n) = f(n - 1) + f(n - 2)
 * @className 斐波那契数列
 */
public class 斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(test1(5));
    }
    private static int test1(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 1) {
            return 0;
        }
        return test1(n - 1) + test1(n - 2);
    }
}
