package org.ziyServlet.web.sql;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/29
 */
public class JdbcDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //得到web程序的一个初始化上下文
            Context ctx = new InitialContext();
            //通过该上下文寻找数据源
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/sqlTest");
            //从数据源中获取一个数据库连接对象
            Connection conn = ds.getConnection();

            //数据库的正常操作
            conn.createStatement().executeUpdate("insert into tomcat_test value('ziy', 'pass')");
            ResultSet resultSet = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("select * from tomcat_test");
            resultSet.beforeFirst();
            resultSet.next();
            String s1 = resultSet.getString(1);
            System.out.println(s1);
            String s2 = resultSet.getString(2);
            System.out.println(s2);
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
}
