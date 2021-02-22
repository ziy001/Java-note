package 位运算;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午9:03 2020/11/29
 * @description TODO:　一个数组里除了某一个数字之外，其他的数字都出现了两次。请写出程序找出这个只出现一次的数字。
 * @className 落单数
 */
public class 落单数 {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 1, 6, 5, 4, 4};
        //根据异或运算规律: 连续异或
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        System.out.println(result);
    }
}
