
/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/15
 */

public class MainTest{
    public static void main(String[] args) {
        A[] a = new A[10];
    }
}


class A {
    static {
        System.out.println("父类进行了类加载");
    }
}
