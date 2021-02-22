package sql_demo.result;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/9 15:23
 * TODO:管理结果集示范
 */
class ResultSetTest {
    private final String driver;
    private final String url;
    private final String user;
    private final String pass;
    /**
     * sql执行语句
     */
    private String sql;

    /**
     * 将调用mysqlMsg.ini配置文件进行初始化
     * @throws IOException 属性文件不存在或加载失败
     */
    public ResultSetTest()
            throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("C:\\Users\\vi193\\Desktop\\mysqlMsg.ini"));
        this.driver = props.getProperty("driver");
        this.user = props.getProperty("user");
        this.url = props.getProperty("url");
        this.pass = props.getProperty("pass");
    }

    public void query()
            throws SQLException {
        //加载驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.print("驱动加载失败");
            e.printStackTrace();
        }
        //创建连接，抛出SQLException异常
        Connection conn = DriverManager.getConnection(url, user, pass);
        //创建一个可滚动、可更新 Statement
        Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet result = state.executeQuery("select * from person");
        //移动到最后一行
        result.last();
        System.out.println(result.getString(2));
        //更新数据并提交
        result.updateString(2, "已更改");
        result.updateRow();
        System.out.println("-----------------------------");
        System.out.println(result.getString(2));

    }
}

public class ResultSetDemo {
    public static void main(String[] args) {
        try {
            new ResultSetTest().query();
        } catch (IOException | SQLException e) {
            System.err.println("1、数据库信息配置失败");
            System.err.println("2、数据库连接失败");
        }
    }
}

