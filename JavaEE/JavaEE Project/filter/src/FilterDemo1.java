import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/21
 */
@WebFilter("/*")
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("执行init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行doFilter...");
//        try {
//            Thread.sleep(10*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("执行destroy...");
    }
}
