package com.ziy.mybatis.sqlsession.impl;

import com.ziy.dao.IUserDao;
import com.ziy.mybatis.sqlsession.SqlSession;
import com.ziy.mybatis.sqlsession.proxy.MapperProxy;
import com.ziy.mybatis.utils.Configuration;
import com.ziy.mybatis.utils.DataSources;

import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/29
 * TODO:SqlSession接口的实现类
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection conn;
    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        this.conn = DataSources.getConnection(cfg);
    }

    /**
     * 创建代理对象
     * @param inter
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> inter) {
        //代理哪个对象就用哪个对象的类加载器
        Object o = Proxy.newProxyInstance(IUserDao.class.getClassLoader(),
                new Class[]{IUserDao.class}, new MapperProxy(cfg.getMappers(), conn));
        return (T)o;
    }

    /**
     * 释放资源
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        if(conn != null) {
            conn.close();
        }
    }
}
