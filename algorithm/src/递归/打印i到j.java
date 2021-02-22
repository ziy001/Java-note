package 递归;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午5:57 2020/11/29
 * @description TODO:
 * @className 打印i减j
 */
public class 打印i到j {
    public static void main(String[] args) {
        test1(4, 10);
    }
    private static void test1(int start, int end) {
        if (start > end) {
            return;
        } else {
            System.out.println(start);
            test1(start + 1, end);
        }
    }
}
