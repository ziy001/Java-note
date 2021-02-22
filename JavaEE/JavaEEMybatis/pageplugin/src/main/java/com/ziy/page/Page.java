package com.ziy.page;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.Properties;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/22
 * TODO:分页插件
 */

public class Page implements Interceptor {
    /**
     * 代替被拦截方法执行
     * @param invocation 封装被拦截的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //获取被拦截的对象
        StatementHandler state = (StatementHandler) invocation.getTarget();
        //获取MetaObject对象
        MetaObject metaObject = SystemMetaObject.forObject(state);
        
        return null;
    }

    /**
     * 创建代理对象
     * @param target 目标对象
     * @return
     */
    @Override
    public Object plugin(Object target) {
        return null;
    }

    /**
     * 属性设置
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {

    }
}
