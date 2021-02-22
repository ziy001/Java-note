package com.ziy.mybatis.sqlsession;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/29
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
