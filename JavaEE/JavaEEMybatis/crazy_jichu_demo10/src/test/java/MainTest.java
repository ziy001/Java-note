import com.ziy.dao.UserDao;
import com.ziy.domain.UserMapper;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.TypeHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/14
 */
public class MainTest {
    private InputStream in;
    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        //读取配置文件
        in = Resources.getResourceAsStream("mybatis-conf.xml");
        //解析数据创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
    }
    @After
    public void close() throws IOException {
//        sqlSession.commit();
        in.close();
        sqlSession.close();
    }
@Test
    public void objectFactoryTest() {
        //调用方法
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<UserMapper> all = mapper.findAll();
        for (UserMapper userMapper : all) {
            System.out.println(userMapper);
        }
    }
}
