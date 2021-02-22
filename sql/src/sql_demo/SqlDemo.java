package sql_demo;

import java.sql.*;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/7 15:17
 * TODO:执行SQL语句
 */
public class SqlDemo {
    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {

        final Class<?> cls = Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库   返回一个Connection对象
        final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test" +
                        "?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true ",
                "root", "ziy001");
        //创建statement对象
        Statement statement = conn.createStatement();
        //使用statement对象执行SQL语句，（直接将SQL语句进行编译执行）
        //执行后会得到一个ResultSet集合，可以通过操作集合来得到结果
        ResultSet resultSet = statement.executeQuery("select * from dml");
        //关闭数据库连接
        conn.close();
        while(resultSet.next()) {
            System.out.println(resultSet.getInt(1) +" "+ resultSet.getString(2));
        }
    }
}
