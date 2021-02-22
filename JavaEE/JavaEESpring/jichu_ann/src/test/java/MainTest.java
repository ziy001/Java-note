import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author ziy
 * @version 1.0
 * @date 上午10:46 2020/11/10
 * @description TODO:
 * @className MainTest
 */
public class MainTest {
    @Test
    public void testRequired() throws IOException {
        var ctx = new ClassPathXmlApplicationContext("beans.xml");
        ctx.getBean("demo1");
//        System.in.read();
    }
}
