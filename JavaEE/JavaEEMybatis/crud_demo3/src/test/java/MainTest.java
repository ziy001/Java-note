import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import ziy.dao.IUserDao;
import ziy.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/1
 */
public class MainTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao mapper;


    @Test
    public void testMap() throws IOException {
        in = Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder()
                .build(in);
        sqlSession = build.openSession();
        mapper = sqlSession.getMapper(IUserDao.class);

        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }

        sqlSession.commit();
        in.close();
        sqlSession.close();
    }
}
