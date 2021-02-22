package com.ziy.ui;

import com.ziy.dao.IUserDao;
import com.ziy.domain.UserMapper;
import com.ziy.mybatis.io.Resources;
import com.ziy.mybatis.sqlsession.SqlSession;
import com.ziy.mybatis.sqlsession.SqlSessionFactory;
import com.ziy.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/29
 */
public class MainTest {
    public static void main(String[] args) {
        //获取配置文件
        InputStream in = Resources.getResourceAsStream("UserMysqlConfig");
        //创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //打开
        SqlSession session = factory.openSession();
        //创建代理对象
        IUserDao mapper = session.getMapper(IUserDao.class);

        List<UserMapper> all = mapper.findAll();
        System.out.println(all);

    }
}
