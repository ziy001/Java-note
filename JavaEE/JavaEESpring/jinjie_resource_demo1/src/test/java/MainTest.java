import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * @author ziy
 * @version 1.0
 * @date 下午4:19 2020/10/21
 * @description TODO:
 * @className MainTest
 */
public class MainTest {
    @Test
    public void resourceTest() {
//        var ctx = new ClassPathXmlApplicationContext("classpath*:beans.xml");
        var ctx = new FileSystemXmlApplicationContext("classpath:beans*.xml");
//        System.out.println(ctx);
//        ctx.getBean("a");
        ctx.getBean("c");
    }
}
