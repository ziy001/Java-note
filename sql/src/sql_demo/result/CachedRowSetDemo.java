package sql_demo.result;

import sql_demo.ConnectionException;
import sql_demo.Connections;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/12 20:38
 */
public class CachedRowSetDemo {
    public static void main(String[] args)
            throws SQLException {
        //使用自动关闭资源的语句
        try(
                Connection conn = Connections.getConnection();
                CachedRowSet cachedRs = RowSetProvider.newFactory().createCachedRowSet();
        ) {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = state.executeQuery("select * from person");
            //特别注意：：：：：：：：：：：：：：：必须在装填数据前就设置页面大小
            cachedRs.setPageSize(1);
            //从指定结果集的第三行开始记录,所指定的ResultSet必须是可滚动的
            cachedRs.populate(resultSet, 3);
            //装填后再设置页面size是无效的
//            cachedRs.setPageSize(1);
            //关闭Conn
            conn.close();
            System.out.println("连接情况: "+ !conn.isClosed());
            //遍历
            cachedRs.beforeFirst();
            while(cachedRs.next()) {
                System.out.println(cachedRs.getString(1)+"   "+cachedRs.getString(2));
            }

            //离线状态修改后可再获取连接够提交修改
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
    }
}
