package com.ziy.mybatis.sqlsession.proxy;

import com.ziy.mybatis.utils.Executor;
import com.ziy.mybatis.utils.Mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/29
 */
public class MapperProxy implements InvocationHandler {
    /**
     * key：全限定类名+方法名
     */
    private Map<String, Mapper> mappers;
    private Connection conn;
    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法名
        String methodName = method.getName();
        //获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        //组合
        String key = className+"."+methodName;
        System.out.println("Test:  "+ key);
        //获取值
        Mapper mapper = this.mappers.get(key);
        if(mapper == null) {
            throw new IllegalArgumentException("传入参数错误");
        }
        //调用工具类查询所有

        return new Executor(conn);
    }
}
