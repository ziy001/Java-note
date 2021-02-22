import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/20
 */
public class MyClassLoader {
    public static void main(String[] args)
            throws Throwable {
        //创建数组
        File file = new File("E:\\项目文件夹\\mysql-connector-java-8.0.20.jar");
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};
        //使用默认的父类加载器
        URLClassLoader loader = new URLClassLoader(urls);
        //调用loadClass方法对类进行加载
        Class<?> aClass = loader.loadClass("com.mysql.cj.jdbc.Driver");
        //调用构造器
        Driver driver = (Driver)aClass.getConstructor().newInstance();
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "ziy001");
        Connection conn = driver.connect("jdbc:mysql://localhost:3306/javatest?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true", props);
        Statement statement = conn.createStatement();
        System.out.println("连接成功");
    }
}
