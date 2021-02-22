package ziy.ann.test;

/**
 * @author ziy
 * @version 1.0
 * @date 上午10:10 2020/10/22
 * @description TODO:
 * @className A
 */
public class A {
    public void aRun() {
        System.out.println("模拟aRun运行");
    }
    public void aRun(int i) {
        System.out.println("模拟aRun运行");
        throw new RuntimeException("抛出Runtime异常");
    }
}
