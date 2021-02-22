package 不定式方程;

/**
 * @author ZIY
 * @version 1.0
 * @date 2021/1/2 上午11:05
 * @description TODO:4 * x - 5 * y = 7  x和y都是整数
 * @className Demo1
 */
public class Demo1 {
    public static void main(String[] args) {
        // 4 * x - 5 * y = 7
//        test1();
        test2();
    }

    /**
     * 使用 暴力枚举
     */
    public static void test1() {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                boolean b = 4 * i - 5 * j == 7;
                if (b) {
                    System.out.println(i + "  " + j);
                }
            }
        }
    }

    /**
     * 改进2
     * 先求出特殊解，再求出另外一个解
     */
    public static void test2() {
        for (int y = 0; y < 1000; y++) {
            boolean b = (7 + 5 * y) % 4 == 0;
            if (b && (7 + 5 * y) / 4 <= 1000) {
                System.out.println((7 + 5 * y) / 4 + "  " + y);
            }
        }
    }
}
