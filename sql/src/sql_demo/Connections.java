package sql_demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/9 18:51
 * TODO:连接数据库的工具类 如果连接出现问题，将返回null;
 */
public class Connections {
    //数据库配置信息
    private final String driver;
    private final String url;
    private final String user;
    private final String password;
    //初始化
    private Connections()
            throws ConnectionException {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("C:\\Users\\vi193\\Desktop\\mysqlMsg.ini"));
        } catch (IOException e) {
            throw new ConnectionException("数据库配置信息初始化失败");
        }
        this.driver = props.getProperty("driver");
        this.url = props.getProperty("url");
        this.user = props.getProperty("user");
        this.password = props.getProperty("pass");
    }
    private Connection connect()
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    public static Connection getConnection()
            throws ConnectionException {
        try {
            return new Connections().connect();
        } catch (Throwable e) {
            throw new ConnectionException("数据库连接错误");
        }
    }

}
