package sql_demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/14 9:30
 */
public class DataBaseDemo {
    public static void main(String[] args) {
        try(Connection conn = Connections.getConnection()) {
            final DatabaseMetaData metaData = conn.getMetaData();
            System.out.println("MySQL数据库是否支持批量更新: "+ metaData.supportsBatchUpdates());
            
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
