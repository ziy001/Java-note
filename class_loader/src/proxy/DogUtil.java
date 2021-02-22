package proxy;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/20
 * TODO:装饰器
 */
public class DogUtil {
    public void method1() {
        System.out.println("开始时间: "+ System.currentTimeMillis() / 1000);
    }
    public void method2() {
        System.out.println("结束时间: "+ System.currentTimeMillis() / 1000);
    }
}
