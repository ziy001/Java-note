package 位运算;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午1:39 2020/11/29
 * @description TODO:一个小数为double类型小数，转换为二进制，如果精度超过32就打印 error
 * @className 小数转换为二进制
 */
public class 小数转换为二进制 {
    public static void main(String[] args) {
        double num = 0.422;
        System.out.println(test1(num));
    }
    private static String test1(double num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if (sb.length() >= 32) {
                return "ERROR";
            }
            num = num * 2;
            if (num >= 1) {
                sb.append("1");
                //删除整数部分
                num -= 1;
            } else {
                sb.append("0");
            }
        }
        return "0."+sb.toString();
    }
}
