package com.ziy;

import com.ziy.dao.AccountDao;
import com.ziy.domain.Account;
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
public class AccountTest {
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
        //查询所有账户信息
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<Account> all = mapper.findAll();
        for (Account account : all) {
            System.out.println("----------------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
