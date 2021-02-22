package ziy.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZIY
 * @version 1.0
 * @date 2021/2/22 上午11:48
 * @description TODO:
 * @className MyAuthenticationFailureHandler
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private String url;
    public MyAuthenticationFailureHandler(String url) {
        this.url = url;
    }
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.sendRedirect(url);
    }
}
