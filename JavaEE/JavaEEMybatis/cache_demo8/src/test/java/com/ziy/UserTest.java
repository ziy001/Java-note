package com.ziy;

import com.ziy.dao.UserDao;
import com.ziy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/7
 */
public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        //读取资源文件
        in = Resources.getResourceAsStream("mybatis-conf.xml");
        //分析
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        sqlSession = build.openSession();
    }

    @After
    public void close() throws IOException {
        //提交事务
//        sqlSession.commit();
        in.close();
        sqlSession.close();
    }


    @org.junit.Test
    public void testFindAll() {
        //查询所用用户信息
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println("-------test-------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
}
