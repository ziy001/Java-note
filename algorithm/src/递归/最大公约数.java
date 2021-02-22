package 递归;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午9:27 2020/11/30
 * @description TODO: f(x, y) = f(x, x % y)
 * @className 最大公约数
 */
public class 最大公约数 {
    public static void main(String[] args) {
        int x = 18;
        int y = 12;
        System.out.println(test1(x, y));
    }
    private static int test1(int x, int y) {
        if (x % y == 0) {
            return y;
        }
        return test1(x, x % y);
    }
}
