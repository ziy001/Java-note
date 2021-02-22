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
 * @date 2020/7/13 15:26
 * TODO:批量更新功能----需要DBMS的支持
 */
public class TestTwo {
    public static void main(String[] args) {
        //在使用批量更新功能的时候最好另起一个事务进行批量处理
        try(Connection conn = Connections.getConnection()) {
            //关闭自动提交（开启事务）
            conn.setAutoCommit(false);
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            try {
                state.addBatch("insert into business(test_name) " +
                        "value('1')");
                state.addBatch("insert into business(test_name) " +
                        "value('2')");
                for (int i : state.executeBatch()) {
                    System.out.println("受影响的行数:  "+ i);
                }
                //提交修改
                conn.commit();
            } catch(SQLException e) {
                System.err.println("事务中语句执行出现问题");
                //回滚
                conn.rollback();
            }
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
