package com.ziy;

import com.ziy.dao.RoleDao;
import com.ziy.domain.Role;
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
 * @date 2020/9/8
 */
public class RoleTest {
    private SqlSession sqlSession;
    private InputStream in;
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

    @Test
    public void testRole() {
        RoleDao mapper = sqlSession.getMapper(RoleDao.class);
        List<Role> all = mapper.findAll();
        for (Role role : all) {
            System.out.println("-----------------");
            System.out.println(role);
            System.out.println(role.getUser());
        }
    }
}
