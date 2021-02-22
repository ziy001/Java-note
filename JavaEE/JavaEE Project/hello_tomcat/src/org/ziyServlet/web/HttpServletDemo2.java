package org.ziyServlet.web;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/23
 */
public class HttpServletDemo2 extends HttpServlet {
    private String greeting;

    @Override
    public void init() throws ServletException {
        greeting = getInitParameter("greeting");
        System.out.println("初始化成功");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("gb2312");
        String usrname = req.getParameter("username");
        PrintWriter out = resp.getWriter();
        out.print(greeting +" , "+ usrname);
        System.out.println("程序运行成功");
    }
}
