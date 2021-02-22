package sql_demo;

import java.sql.*;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/7 18:35
 * TODO:示范数据库的直接编译执行 和 预编译执行 的效率和安全性
 */
public class Sql_login {
    public static void main(String[] args) {
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            //驱动类加载失败,退出程序
            System.exit(-1);
        }
        //测试第一个效率
        long start = System.currentTimeMillis();
        login_one();
        long end = System.currentTimeMillis();
        System.out.println("直接编译运行时间: " + (end - start));
        //测试第二个效率
        start = System.currentTimeMillis();
        login_two();
        end = System.currentTimeMillis();
        System.out.println("预编译运行时间: " + (end - start));
    }

    public static void login_one() {
        //连接数据库
        try(final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaTest?" +
                        "serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8",
                "root", "ziy001") ) {
            System.out.println("数据库连接成功");
            //获取Statement对象
            Statement statement = conn.createStatement();
            //使用statement对象执行SQL语句
            for(int i = 0; i < 100; i++) {
                statement.executeUpdate("insert into person(user_name, user_id, user_pass) value('张三', 1, '123123123')");
            }

        } catch (SQLException throwables) {
            System.err.println("数据库连接失败");
            throwables.printStackTrace();
        }
    }

    public static void login_two() {
        try(final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaTest?" +
                        "serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8",
                "root", "ziy001") ) {
            System.out.println("数据库连接成功");
            //获取Statement对象
            PreparedStatement statement = conn
                    .prepareStatement("insert into person(user_name, user_id, user_pass) value('王五', 2, '3123123')");
            //使用statement对象执行SQL语句
            for(int i = 0; i < 100; i++) {
                statement.executeUpdate();
            }

        } catch (SQLException throwables) {
            System.err.println("two数据库连接失败");
            throwables.printStackTrace();
        }
    }
}
