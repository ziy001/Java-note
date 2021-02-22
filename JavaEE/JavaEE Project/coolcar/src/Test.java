import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/22
 */
public class Test extends HttpServlet {
    @org.junit.Test
    public void test1() throws IOException {
        String parent = getInitParameter("projectPath");
        System.out.println(parent);
        System.out.println(new File(parent).getAbsolutePath());
        File file = new File(parent+"web/WEB-INF/conf/news.conf");
        URL resource = Test.class.getClassLoader().getResource("");
        System.out.println(file.getAbsolutePath());
    }
}
