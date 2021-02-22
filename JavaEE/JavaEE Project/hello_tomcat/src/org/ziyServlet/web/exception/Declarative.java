package org.ziyServlet.web.exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/31
 * TODO:声明式异常处理
 */
public class Declarative extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("GBK");
        System.out.println("该类运行了!!!");
        try{
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            System.out.println("出错！！！");
        }
    }
}
