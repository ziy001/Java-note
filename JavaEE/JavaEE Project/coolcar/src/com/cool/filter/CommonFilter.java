package com.cool.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Map;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/22
 * TODO:常用过滤器
 */
public class CommonFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CommonFilter initing...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setCharacterEncoding("utf-8");
        Map<String, String[]> map = servletRequest.getParameterMap();

    }

    @Override
    public void destroy() {

    }
}
