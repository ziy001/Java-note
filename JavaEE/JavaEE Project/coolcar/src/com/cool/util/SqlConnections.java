package com.cool.util;

import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/22
 * TODO:获取数据库链接的工具类
 */
public class SqlConnections {

    private SqlConnections(){}

    /**
     * 根据配置文件返回一个数据库链接
     * @return 数据库链接
     */
    public static Connection getConnection() {
        //获取数据库连接
        Connection conn = null;
        try {
            InitialContext ict = new InitialContext();
            DataSource ds = (DataSource) ict.lookup("java:comp/env/jdbc/cool");
            conn = ds.getConnection();
        } catch (NamingException | SQLException e) {
            System.err.println("数据库链接获取失败");
            e.printStackTrace();
        }
        return conn;
    }
}
