package 省赛真题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZIY
 * @version 1.0
 * @date 2021/1/6 上午9:45
 * @description TODO:作物杂交：
 *  1.先通过回溯算法得到目标种子需要的杂交方式（需要一个List记录已存在的种子）
 *  2.在杂交公式中找出初始化种子的杂交公式
 *  3.继续，将其他杂交公式中能通过List集合中的种子进行的全部计算出所需时间，取最长
 *  4.继续第三步，直到杂交公式全部计算完毕
 * @className I
 */
public class I {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        //读取第一行
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int K = sc.nextInt();
//        int T = sc.nextInt();
//        //读取第二行
//        int[] times = new int[N];
//        for (int i = 0; i < times.length; i++) {
//            times[i] = sc.nextInt();
//        }
//        //读取第三行
//        int[] initSeed = new int[M];
//        for (int i = 0; i < initSeed.length; i++) {
//            initSeed[i] = sc.nextInt();
//        }
//        //读取后续方案
//        int[][] idea = new int[K][3];
//        for (int i = 0; i < idea.length; i++) {
//            int[] ints = new int[3];
//            for (int i1 = 0; i1 < ints.length; i1++) {
//                ints[i1] = sc.nextInt();
//            }
//            idea[i] = ints;
//        }
        int T = 6;
        int[][] idea = {{1, 2, 3}, {1, 3, 4}, {2, 3, 5}, {4, 5, 6}};
        List<Integer> initSeeds = new ArrayList<>();
        initSeeds.add(1);
        initSeeds.add(2);
        int[] times = {5, 3, 4, 6, 4, 9};
        test(T, idea, initSeeds, times);
        System.out.println(res);
    }
    static int res = 0;
    public static int test(int T, int[][] idea, List<Integer> initSeeds, int[] times) {

        return 0;
    }

    public static void flashBack(int T, int[][] idea, int[] initSeeds, List<Integer> seeds) {
        for (int initSeed : initSeeds) {
            if (T == initSeed) {
                return;
            }
        }
        //通过回溯找出所需的种子
//        for (int i = 0; i < idea.length; i++) {
//            if (idea[i][2] == T) {
//                seeds.add()
//                flashBack(T, idea);
//            }
//        }
    }
}
