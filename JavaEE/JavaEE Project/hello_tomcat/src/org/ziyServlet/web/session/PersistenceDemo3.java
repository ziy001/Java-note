package org.ziyServlet.web.session;

import org.apache.catalina.session.StandardManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/31
 */
public class PersistenceDemo3 extends HttpServlet implements Serializable {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
