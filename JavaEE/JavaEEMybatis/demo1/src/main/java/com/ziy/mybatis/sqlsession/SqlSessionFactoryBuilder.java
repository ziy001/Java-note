package com.ziy.mybatis.sqlsession;

import com.ziy.mybatis.sqlsession.impl.DefaultSqlSessionFactory;
import com.ziy.mybatis.utils.Configuration;
import com.ziy.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/29
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in) {
        //将资源文件输入流交给dom4j用于解析数据
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        //调用DefaultSqlSessionFactory来初始化配置信息
        return new DefaultSqlSessionFactory(cfg);
    }

}
