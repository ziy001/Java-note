package org.ziyServlet.web;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/23
 */
public class HelloMyServlet implements Servlet {
    private ServletConfig config;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        PrintWriter out = servletResponse.getWriter();
        out.print("Hello Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        config = null;
    }
}
