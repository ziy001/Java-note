package sql_demo;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/9 18:44
 * TODO:JDBC对Blob数据类型的操作
 */
public class Blob {
    public static void main(String[] args) {
        try(final Connection conn = Connections.getConnection();
            FileInputStream fis = new FileInputStream("C:\\Users\\vi193\\Desktop\\test.jpg");
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\vi193\\Desktop\\copy"))
        ) {
            PreparedStatement prepareState = conn.prepareStatement("insert into blob_test value(?)");
            prepareState.setBinaryStream(1, fis);
            prepareState.executeUpdate();
            //获取数据库数据
            ResultSet resultSet = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("select * from blob_test");
            resultSet.last();
            final byte[] bytes = resultSet.getBytes(1);
            //将输入流读取数据并保存到桌面
            bos.write(bytes);
            System.out.println("写入成功");
        } catch (Throwable e) {
            System.err.println("数据库连接异常");
            e.printStackTrace();
        }
    }
}
