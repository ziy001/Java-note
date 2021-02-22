import com.ziy.dao.UserDao;
import com.ziy.domain.User;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/18
 */
@Intercepts()
public class MainTest {
    private InputStream in;
    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-conf.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
    }
    @After
    public void close() throws IOException {
        sqlSession.close();
    }
    @Test
    public void testFindAll() {
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        System.out.println(mapper.findAll());
        System.out.println(mapper.findAll());

    }
}
