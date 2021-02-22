import org.junit.Test;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ziy.four.BTest;
import ziy.own.ConcurrentMapDemo;
import ziy.third.TestA;

/**
 * @author ziy
 * @version 1.0
 * @date 上午9:51 2020/10/23
 * @description TODO:
 * @className MainTest
 */
public class MainTest extends BTest {
    @Test
    public void ownTest() throws InterruptedException {
        var ctx = new ClassPathXmlApplicationContext("beans.xml");
        TestA a = ctx.getBean("a", TestA.class);
        System.out.println(a.aRun1(1));
        Thread.sleep(3000);
        System.out.println(a.aRun1(1));
        a.clear();
    }
}
