package 计算浮点数;

/**
 * @author ZIY
 * @version 1.0
 * @date 2021/1/2 上午10:17
 * @description TODO:IEEE745计算标准中的五种特殊值
 * @className 五种特殊值
 */
public class 五种特殊值 {
    public static void main(String[] args) {
        //  Infinity  表示无限大
        // NaN  表示不是一个数
        double a = 3.0/0;
        double b = a - 1;
        double c = a / a;
        System.out.println(a);
        System.out.println(a * -1);
        System.out.println(1 / a);
        System.out.println(-1 / a);
//        System.out.println(b);
        System.out.println(c);
    }
}
