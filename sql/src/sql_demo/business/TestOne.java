package sql_demo.business;

import sql_demo.ConnectionException;
import sql_demo.Connections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/13 14:18
 * TODO:JDBC对事务的支持
 */
public class TestOne {
    public static void main(String[] args) {
        try(
                Connection conn = Connections.getConnection();
                Connection connection = Connections.getConnection();

        ) {
            //通过设置Connection对象中自动提交属性
            //关闭自动提交就是事务开启
            conn.setAutoCommit(false);
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            System.out.println("滚动性 "+ state.getResultSetType());
            System.out.println("并发性 "+ state.getResultSetConcurrency());
            //执行DML语句
            try {
                state.executeUpdate("insert into business(test_name) " +
                        "value('one')");
                state.executeUpdate("insert into business(test_name) " +
                        "value('two')");
                //在发生异常之前提交
//                conn.commit();
                //该语句将会抛出异常
                state.executeUpdate("insert into business(u_name) " +
                        "value('three')");
                state.executeUpdate("insert into business(test_name) " +
                        "value('three')");
            } catch(Throwable e) {
                System.err.println("捕获异常");
                System.err.println("不能自动回滚事务");
//                conn.rollback();
            }
            //输出现在数据库中的内容
            //有输出，体现了事务的隔离性
            print(state);
            System.out.println("隔离性");
            print(connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            //提交
            conn.commit();
            print(state);

        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void print(Statement state)
            throws SQLException {
        ResultSet resultSet = state.executeQuery("select * from business");
        resultSet.beforeFirst();
        System.out.println();
        System.out.println("start...");
        while(resultSet.next()) {
            System.out.println(resultSet.getString(1) +"  "+ resultSet.getString(2));
        }
        System.out.println("end...");
    }
}
