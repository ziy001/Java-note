import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ziy.dao.domain.Book;
import ziy.service.service.BookService;

/**
 * @author ziy
 * @version 1.0
 * @date 上午8:00 2020/11/7
 * @description TODO:
 * @className MainTest
 */
public class MainTest {
    @Test
    public void testOne() {
        //获取容器
        var ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");
        //获取service组件
        BookService service = ctx.getBean("bookService", BookService.class);
        //调用service组件方法
//        service.saveBook(new Book("疯狂Java讲义", "李刚", "java基础入门书籍"));
//        service.saveBook(new Book("疯狂Javaweb轻量级开发", "李刚", "SSM框架学习书籍"));
        Book book = service.getBook(1);
        System.out.println(book);

    }
}
