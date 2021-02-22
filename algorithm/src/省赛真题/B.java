package 省赛真题;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * @author ZIY
 * @version 1.0
 * @date 2020/12/26 上午11:16
 * @description TODO:寻找2020
 *              TODO:直接通过判断当前元素三个方向的剩余元素个数来判断是否可以继续进行匹配，这样就避免了越界异常
 * @className B
 */
public class B {
    public static void main(String[] args) {
//        char[][] rect = {
//                {'2', '2', '0', '0', '0', '0'},
//                {'0', '0', '0', '0', '0', '0'},
//                {'0', '0', '2', '2', '0', '2'},
//                {'0', '0', '0', '0', '0', '0'},
//                {'0', '0', '0', '0', '2', '2'},
//                {'0', '0', '2', '0', '2', '0'},
//        };
        //读取文件内容构造成二维数组
        char[][] rect = new char[300][300];
        try (BufferedReader br = new BufferedReader(new FileReader("/home/ziy/ZIY/AllProject/Java_Idea_project/algorithm/src/省赛真题/2020.txt"))) {
            for (int i = 0; i < rect.length; i++) {
                rect[i] = br.readLine().toCharArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for (int i = 0; i < rect.length; i++) {
//            for (int j = 0; j < rect[i].length; j++) {
//                System.out.print(rect[i][j] + "  ");
//            }
//            System.out.println();
//        }
        //调用输出
        System.out.println(test1(rect));
    }

    public static int test1(char[][] rect) {
        int count = 0;
        for (int i = 0; i < rect.length; i++) {
            for (int j = 0; j < rect[i].length; j++) {
                //分别对每个元素进行 横向、列向。斜向的遍历寻找
                if (line(rect, i, j)) {
                    count++;
                }
                if (col(rect, i, j)) {
                    count++;
                }
                if (dia(rect, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean line(char[][] rect, int i, int j) {
        if (j > rect[i].length - 4) {
            //横向无法再匹配，直接返回false
            return false;
        }
        StringBuilder sb = new StringBuilder("");
        for (int k = 0; k < 4; k++) {
            sb.append(rect[i][j]);
            j++;
        }
        return Objects.equals(sb.toString(), "2020");
    }
    private static boolean col(char[][] rect, int i, int j) {
        if (i > rect.length - 4) {
            //列向无法再匹配，直接返回false
            return false;
        }
        StringBuilder sb = new StringBuilder("");
        for (int k = 0; k < 4; k++) {
            sb.append(rect[i][j]);
            i++;
        }
        return Objects.equals(sb.toString(), "2020");
    }
    private static boolean dia(char[][] rect, int i, int j) {
        int min = Math.min(rect.length - i, rect[i].length - j);
        if (min < 4) {
            //该斜线上剩余字符不足4个，直接返回false
            return false;
        }
        StringBuilder sb = new StringBuilder("");
        for (int k = 0; k < 4; k++) {
            sb.append(rect[i][j]);
            i++;
            j++;
        }
        return Objects.equals(sb.toString(), "2020");
    }
}
