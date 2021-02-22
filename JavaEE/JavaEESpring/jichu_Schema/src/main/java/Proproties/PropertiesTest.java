package Proproties;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午10:00 2020/11/23
 * @description TODO:
 * @className PropertiesTest
 */
public class PropertiesTest {
    private String name;
//    private int order;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getOrder() {
        System.out.println("调用了get-Order");
        return 1;
    }
    public void setOrder(int i) {
        System.out.println("调用了set-Order");
    }

}
