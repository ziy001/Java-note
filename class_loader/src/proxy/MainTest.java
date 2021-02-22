package proxy;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/20
 */
public class MainTest {
    public static void main(String[] args) {
        Test test = new Test();
        Object accept = MyProxyFactory.accept(test);
        Test t = (Test)accept;
        t.test();
    }
}
class Test {
    public void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}