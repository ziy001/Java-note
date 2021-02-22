package org.ziyServlet.web.session;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/30
 */
public class RedictLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter out = resp.getWriter()) {
            out.println(req.getSession().getId());
            Cookie[] cookies = req.getCookies();
            if(cookies != null && cookies.length != 0) {
                for (Cookie cookie : cookies) {
                    out.println(cookie.getValue());
                }
            }
        }
    }
}
