package sql_demo.connectpool;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/15
 */
public class PoolOne {
    public static void main(String[] args)
            throws SQLException {
        //创建对象
        try(final Connection conn = getConnect()) {
            
        }


    }
    public static Connection getConnect()
            throws SQLException {
        BasicDataSource ds = new BasicDataSource();
        Properties props = new Properties();
        try {
            props.load(new FileReader("C:\\Users\\vi193\\Desktop\\mysqlMsg.ini"));
            ds.setDriverClassName(props.getProperty("driver"));
            ds.setUrl(props.getProperty("url"));
            ds.setUsername(props.getProperty("user"));
            ds.setPassword(props.getProperty("pass"));
        } catch (IOException e) {
            System.err.println("初始化数据库连接池失败");
            System.exit(-1);
        }
        return ds.getConnection();
    }
}
