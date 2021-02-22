package org.ziyServlet.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/24
 */
public class ServerContextDemo3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //获取一个多个Servlet实例的共享属性
        ServletContext context = getServletContext();
        //因为多个Servlet共享一个ServletContext对象
        synchronized (context) {
            Integer num = (Integer)context.getAttribute("userNum");
            if(num == null) {
                num = Integer.valueOf(1);
            }
            else {
                num++;
            }
            context.setAttribute("userNum", num);
            try(PrintWriter out = resp.getWriter()) {
                out.print(num);
            }
        }
    }
}
