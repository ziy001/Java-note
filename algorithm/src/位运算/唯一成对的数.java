package 位运算;

import java.util.Random;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午8:13 2020/11/29
 * @description TODO:1-1000这1000个数放在含有1001个元素的数组中，只有唯一的一个元素值重复，其他均只出现一次。每个数组元素只能访问一次，设计一个算法，将它找出来；不用辅助存储空间，能否设计一个算法实现？
 * @className 唯一成对的数
 */
public class 唯一成对的数 {
    public static void main(String[] args) {
        int N = 11;
        int[] arr = new int[N];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i + 1;
        }
        //在最后一位随机产生与前面某一个相同的数
        arr[arr.length - 1] = arr[new Random().nextInt(N - 1)];
        int s = new Random().nextInt(N - 1);
        int x = arr[arr.length - 1];
        arr[arr.length - 1] = arr[s];
        arr[s] = x;

        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println(test(arr));
    }
    private static int test(int[] arr) {
        int x = 0;
        for (int i = 1; i <= arr.length - 1; i++) {
            x = x ^ i;
        }
        for (int i = 0; i < arr.length; i++) {
            x = x ^ arr[i];
        }
        return x;
    }
}
