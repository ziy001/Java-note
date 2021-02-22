package ziy.four;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午9:49 2020/11/23
 * @description TODO:
 * @className BMainTest
 */
public class BMainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        BTest b = ctx.getBean("b", BTest.class);
        for (int i = 0; i < 3; i++) {
            b.publicTest();
            b.protectedTest();
            b.defaultTest();
        }
    }
}
