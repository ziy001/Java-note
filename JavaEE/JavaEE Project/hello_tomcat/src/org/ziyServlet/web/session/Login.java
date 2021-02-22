package org.ziyServlet.web.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/30
 * TODO:跨浏览器共享Session
 * 
 */
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("GBK");
        //获取session对象
        HttpSession session = req.getSession();
        //创建Cookie
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setVersion(1);
        cookie.setMaxAge(30 * 60);
        //加到响应体中
//        resp.addCookie(cookie);
        resp.setHeader("Set-Cookie", "JSESSIONID"+ "=" +session.getId());
        //重定向
        resp.sendRedirect("/s2");

    }
}
