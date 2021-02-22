import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午10:05 2020/11/23
 * @description TODO:
 * @className MainTest
 */
public class MainTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Object props = ctx.getBean("props");
        Object p = ctx.getBean("p");
    }
}
