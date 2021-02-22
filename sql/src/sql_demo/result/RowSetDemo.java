package sql_demo.result;

import sql_demo.Connections;

import java.io.IOException;
import java.sql.*;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/10 18:47
 * TODO:RowSet接口示范
 */
public class RowSetDemo {
    public static void main(String[] args) throws InterruptedException {
        try(Connection conn = Connections.getConnection()) {
            final Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //设置自动关闭
            statement.closeOnCompletion();
            final ResultSet resultSet = statement.executeQuery("select * from person");
            resultSet.last();
            resultSet.getString(2);
            System.out.println();
            System.out.println();
            System.out.println("返回集合完毕");

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
