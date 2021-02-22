package 递归;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午5:50 2020/11/29
 * @description TODO:  f(n) = n * f(n - 1)
 * @className 阶乘
 */
public class 阶乘 {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(test1(num));
    }

    private static int test1(int num) {
        if(num == 1) {
            return num;
        } else {
            return num * test1(num - 1);
        }
    }
}
