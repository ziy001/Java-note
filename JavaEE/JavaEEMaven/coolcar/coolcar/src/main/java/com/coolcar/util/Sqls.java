package com.coolcar.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/24
 * TODO:数据库操作类
 */
public class Sqls {
    private static DataSource ds;
    //连接数据库
    static {
        try {
            //得到数据源
            InitialContext ict = new InitialContext();
            ds = (DataSource) ict.lookup("java:comp/env/jdbc/coolcar");

        } catch (NamingException e) {
            System.err.println("数据库初始化连接失败!");
            System.err.println("请检查数据库的配置!");
            //停止程序
            System.exit(1);
        }
    }

    public static ResultSet sql(String sql) throws SQLException {
        CachedRowSet rowSet = null;
        //获取数据库链接
        try(
                Connection conn = ds.getConnection();
                ResultSet rs = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                                .executeQuery(sql)) {
            //创建离线RowSet
            rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.populate(rs);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }
        return rowSet;
    }
}
