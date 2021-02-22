import java.lang.reflect.Array;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/19
 */
public class ReArray {
    public static void main(String[] args) {
        //深入反射动态操作数组

        //创建数组
        /*
        o是一个三维数组
        三维数组的第一个索引 是一个二维数组
         */
        Object o = Array.newInstance(String.class, 2, 2, 2);
        Object o1 = Array.get(o, 1);
        System.out.println(o);
        System.out.println(o1);
        System.out.println(Array.get(o1, 1));

    }
}
