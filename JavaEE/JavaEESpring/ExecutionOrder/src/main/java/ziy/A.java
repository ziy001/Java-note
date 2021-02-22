package ziy;

/**
 * @author ziy
 * @version 1.0
 * @date 上午9:08 2020/11/7
 * @description TODO:
 * @className A
 */
public class A {
    private String param1;

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        System.out.println("====设值注入====");
        this.param1 = param1;
    }
    private void init() {
        System.out.println("====init执行=====");
    }
    private void destroy() {
        System.out.println("====destroy执行====");
    }
    @Override
    public String toString() {
        return "A{" +
                "param1='" + param1 + '\'' +
                '}';
    }
}
