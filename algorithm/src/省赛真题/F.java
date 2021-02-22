package 省赛真题;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author ZIY
 * @version 1.0
 * @date 2021/1/2 下午1:15
 * @description TODO:成绩统计
 * @className F
 */
public class F {
    public static void main(String[] args) {
        //完成数据的输入
        Scanner sc = new Scanner(System.in);
        int size = 0;
        size = sc.nextInt();
        int[] scores = new int[size];
        int i = 0;
        while (i < size && sc.hasNextInt()) {
            scores[i] = sc.nextInt();
            i++;
        }
//        int[] scores = new int[]{80, 92, 56, 74, 88, 100, 0};
        //对数据进行处理
        for (int t : handle1(scores)) {
            System.out.println(t+"%");
        }
    }

    public static int[] handle1(int[] scores) {
        int pass = 0;
        int fine = 0;
        for (int score : scores) {
            if (score >= 60) {
                pass++;
            }
            if (score >= 85) {
                fine++;
            }
        }
        pass *= 100;
        fine *= 100;
        int passRes = Math.round((float) pass / scores.length);
        int fineRes = Math.round((float) fine / scores.length);
        return new int[]{passRes, fineRes};
    }
}
