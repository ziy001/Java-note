package 省赛真题;

/**
 * @author ZIY
 * @version 1.0
 * @date 2020/12/26 上午10:44
 * @description TODO:
 * @className A
 */
public class A {
    public static void main(String[] args) {
        int x = 78120;
        System.out.println(test1(x));
    }

    public static int test1(int x) {
        int result = 0;
        for (int i = 1; i < x; i++) {
            if (x % i == 0) {
                result++;
            }
        }
        return result;
    }
}
