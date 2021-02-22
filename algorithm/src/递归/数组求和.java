package 递归;

import java.util.Arrays;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午8:33 2020/11/30
 * @description TODO: arr[0] + arr[1, arr.length]
 * @className 数组求和
 */
public class 数组求和 {
    private static int i = 0;
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 2, 1};
        System.out.println("正确答案: " + Arrays.stream(arr).sum());
        System.out.println(test1(arr));
    }
    private static int test1(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int[] ints = Arrays.copyOfRange(arr, 1, arr.length);
        return arr[0] + test1(ints);
    }
}
