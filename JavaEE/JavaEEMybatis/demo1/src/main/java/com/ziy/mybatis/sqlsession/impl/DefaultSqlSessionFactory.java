package com.ziy.mybatis.sqlsession.impl;

import com.ziy.mybatis.sqlsession.SqlSession;
import com.ziy.mybatis.sqlsession.SqlSessionFactory;
import com.ziy.mybatis.utils.Configuration;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/29
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
