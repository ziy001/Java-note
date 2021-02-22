package org.ziyServlet.web;

import javax.servlet.RequestDispatcher;
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
 * TODO:forward和include的区别
 */
public class RedirectDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dis = getServletContext().getRequestDispatcher("/forward");
        PrintWriter out = resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        out.println("before");
        dis.forward(req, resp);
        out.println("after");


        out.close();

    }
}
