package 递归;

/**
 * @author ZIY
 * @version 1.0
 * @date 2020/12/26 上午9:46
 * @description TODO:从n个球中取出m个球(不放回)，有多少种取法 ---变换问题--- 从n个球中取出m个球(不放回) 且必须取出某一个球，有多少种取法
 *              TODO:为自己添加条件，来创建条件
 * @className 取球
 */
public class 取球 {
    public static void main(String[] args) {
        int i = test1(100, 3);
        System.out.println(i);
    }

    public static int test1(int n, int m) {
        //递归出口
        if (n < m) {
            return 0;
        }
        if (n == m) {
            return 1;
        }
        if (m == 0) {
            return 1;
        }
        //包含某个球X, 取到了X + 没取到X
        return test1(n - 1, m - 1) + test1(n - 1, m);
    }
}
