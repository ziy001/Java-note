import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ziy.ann.test.A;
import ziy.ann.test.B;

/**
 * @author ziy
 * @version 1.0
 * @date 上午10:12 2020/10/22
 * @description TODO:
 * @className MainTest
 */
public class MainTest {
    ApplicationContext ctx;
    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("xml/beans.xml");
    }
    @Test
    public void annTest() {
        A a = ctx.getBean("a", A.class);
        a.aRun();
        System.out.println("\n");
        try {
            a.aRun(1);
        } catch (RuntimeException e) {
            System.err.println("处理异常之后依然抛到调用者处理");
        }
    }
    @Test
    public void xmlTest() {
        ziy.xml.test.A a = ctx.getBean("a", ziy.xml.test.A.class);
        a.aRun();
        System.out.println("\n");
        try {
            a.aRun(1);
        } catch (RuntimeException e) {
            System.err.println("处理异常之后依然抛到调用者处理");
        }
    }
    @Test
    public void argTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ann/beans.xml");
        B b = ctx.getBean("b", B.class);
        b.bRun("姓名", 100, new Object());
    }
}
