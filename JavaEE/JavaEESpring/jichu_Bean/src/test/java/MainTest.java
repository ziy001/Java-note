import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ziy
 * @version 1.0
 * @date 下午8:07 2020/10/25
 * @description TODO:
 * @className MainTest
 */
public class MainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beansA.xml");
        ctx.getBean("a");
    }
}
