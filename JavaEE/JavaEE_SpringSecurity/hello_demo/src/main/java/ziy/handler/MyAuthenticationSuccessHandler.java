package ziy.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZIY
 * @version 1.0
 * @date 2021/2/22 上午10:16
 * @description TODO:
 * @className MyAuthenticationSuccessHandler
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private String url;

    public MyAuthenticationSuccessHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //获取当前成功登录用户的UserDetails实现类（对象）
        User user = (User)authentication.getPrincipal();
        System.out.println("用户名: " + user.getUsername());
        System.out.println("密码(为了安全显示为null): " + user.getPassword());
        System.out.println("用户权限: " + user.getAuthorities());
        //重定向到指定页面
        httpServletResponse.sendRedirect(url);
    }
}
