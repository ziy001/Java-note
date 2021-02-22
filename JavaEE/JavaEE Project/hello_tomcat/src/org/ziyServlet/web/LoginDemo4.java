package org.ziyServlet.web;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/24
 * TODO:请求转发示例----用户登录功能简单实现----顺便测试两个转发方法的区别
 */
public class LoginDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        RequestDispatcher dis = req.getRequestDispatcher("/ziy");

        out.print("测试点1");
        //当刷新了响应体的缓冲区，则使用forward()方法转发请求会抛出异常
//        resp.flushBuffer();
        try {
//            dis.forward(req, resp);
            dis.include(req, resp);
        } catch (IllegalStateException e) {
            String s = "发生异常！！！";
            System.err.println(s);
            out.print(s);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
