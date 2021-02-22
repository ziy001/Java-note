package com.ziy;

import com.ziy.dao.UserDao;
import com.ziy.domain.User;
import org.apache.ibatis.io.Resources;
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
 * @date 2020/9/7
 */
public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        //读取资源文件
        in = Resources.getResourceAsStream("mybatis-conf.xml");
        //分析
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
    }

    @After
    public void close() throws IOException {
        //提交事务
//        sqlSession.commit();
        in.close();
        sqlSession.close();
    }


    @org.junit.Test
    public void testFirstLevelCache() {
        //查询所用用户信息
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<User> all = mapper.findAll();
        //关闭
//        sqlSession.clearCache();
        //打开重新查询
//        SqlSession session = factory.openSession();
//        UserDao mapper1 = session.getMapper(UserDao.class);

        List<User> all1 = mapper.findAll();
    }

    @Test
    public void testSecondLevelCache() {
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.findAll();
        System.out.println(sqlSession);

        //一级缓存消失
        sqlSession.close();

        SqlSession sqlSession1 = factory.openSession();
        UserDao mapper1 = sqlSession1.getMapper(UserDao.class);
        mapper1.findAll();
        System.out.println(sqlSession1);

        System.out.println(sqlSession == sqlSession1);
    }
}
