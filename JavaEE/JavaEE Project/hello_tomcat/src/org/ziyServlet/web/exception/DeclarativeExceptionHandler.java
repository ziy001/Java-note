package org.ziyServlet.web.exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/31
 */
public class DeclarativeExceptionHandler extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("GBK");
        try(PrintWriter out = resp.getWriter()) {
            Integer code = (Integer) req.getAttribute("javax.servlet.error.status_code");
            out.println("状态码:  "+ code);
        }
    }
}
