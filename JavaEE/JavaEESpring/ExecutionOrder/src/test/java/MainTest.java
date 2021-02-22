import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ziy.A;

/**
 * @author ziy
 * @version 1.0
 * @date 上午9:54 2020/11/7
 * @description TODO:
 * @className MainTest
 */
public class MainTest {
    @Test
    public void test() {
        var ctx = new ClassPathXmlApplicationContext("beans.xml");
        ctx.registerShutdownHook();
        A a = ctx.getBean("a", A.class);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
