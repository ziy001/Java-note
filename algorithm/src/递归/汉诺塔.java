package 递归;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午10:12 2020/11/30
 * @description TODO:重点看一下
 * @className 汉诺塔
 */
public class 汉诺塔 {
    public static void main(String[] args) {
        //表示有4个盘子，需要从A开始移动到C，中间B为辅助
        hanoi(5, "A", "B", "C");
    }

    /**
     *
     * @param n 移动的个数
     * @param A 需要移动的塔的起始位置
     * @param B 中间位置
     * @param C 落点位置 (最终位置)
     */
    public static void hanoi(int n, String A, String B, String C) {
        //如果只有一个需要移动，那么直接从A移动到C即可，作为递归出口
        if (n == 1) {
            move(A, C);
            return;
        }
        //如果不是一个需要移动，那么从A开始绕过C移动到B
        hanoi(n - 1, A, C, B);
        //再把最后一块,从A直接移动到C
        move(A, C);
        //最后把刚刚移动到B上的盘子，从B通过A移动到C
        hanoi(n - 1, B, A, C);
        //至此，移动完毕
    }
    public static void move(String start, String end) {
        System.out.printf("%s -> %s\n", start, end);
    }
}
