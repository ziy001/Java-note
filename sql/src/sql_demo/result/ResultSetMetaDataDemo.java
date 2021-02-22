package sql_demo.result;

import sql_demo.Connections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/10 18:06
 * TODO:描述ResultSet的对象（元数据）
 */
public class ResultSetMetaDataDemo {
    public static void main(String[] args) {
        try(final Connection conn = Connections.getConnection()) {
            final ResultSet result = conn.createStatement().executeQuery("select * from blob_test");
            final ResultSetMetaData meta = result.getMetaData();
            String name = meta.getColumnName(1);
            System.out.println(name);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
