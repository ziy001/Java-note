package sql_demo.result;

import sql_demo.ConnectionException;
import sql_demo.Connections;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/11 22:19
 * TODO:通过测试，摸清不同类型结果集的存储方式
 */
public class ResultSetRowSetTest {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException, SQLException {
//        resultSetTest();
        jdbcRowSetTest();
    }

    /**
     * ResultSet结果集的存储方式测试
     */
    private static void resultSetTest() {
        try(final Connection conn = Connections.getConnection()) {
            //执行查询语句，获取结果集
            ResultSet resultSet = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("select * from person");
            //
            resultSet.first();
            String s = resultSet.getString(2);
            System.out.println(s);

        } catch (ConnectionException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * jdbcRowSet测试（直接访问数据库，不存储本地）
     */
    private static void jdbcRowSetTest()
            throws SQLException {
        //创建一个数据为空的JdbcRowSet
        JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet();
        //设置值 进行连接
        jdbcRs.setUrl("jdbc:mysql://localhost:3306/javatest" +
                "?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true");
        jdbcRs.setUsername("root");
        jdbcRs.setPassword("ziy001");
        //在填充前
        try{
            jdbcRs.last();
            String s1 = jdbcRs.getString(2);
            System.out.println(s1);
        }catch (Throwable e) {
            System.err.println("没有填充，无结果");
        }
        //执行查询
        jdbcRs.setCommand("select * from person");
        jdbcRs.execute();
        //循环遍历
        jdbcRs.first();
        String s2 = jdbcRs.getString(2);
        System.out.println(s2);
    }
    private static void cRowSetTest()
            throws SQLException {
        CachedRowSet cachedRs = RowSetProvider.newFactory().createCachedRowSet();
        
    }
}
