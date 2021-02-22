package ziy;

import com.sun.tools.javac.Main;

import java.io.Serializable;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/22
 */
public class MainTest implements Serializable {
    public static void main(String[] args) {
        //创建对象
        MainTest m = new MainTest();
        //创建代理对象
        Proxys proxys = new Proxys(m);
        MainTest wrap = (MainTest)proxys.wrap();
        wrap.test();

    }
    public void test() {
        System.out.println("Test方法");

    }
    private String reverse(String target) {
        StringBuilder sb = new StringBuilder();
        for (int i = target.length() - 1; i >= 0; i++) {
            sb.append(target.charAt(i));
        }
        return sb.toString();
    }
}
