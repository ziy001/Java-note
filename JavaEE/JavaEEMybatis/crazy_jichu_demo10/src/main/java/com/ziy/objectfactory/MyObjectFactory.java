package com.ziy.objectfactory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/14
 */
public class MyObjectFactory extends DefaultObjectFactory {
    /**
     * 根据映射类的无参构造器构建对象
     * @param type
     * @param <T>
     * @return
     */
    @Override
    public <T> T create(Class<T> type) {
        System.out.println("使用无参构造方法创建对象 "+type);
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        System.out.printf("类 %s, 构造器 %s, 参数 %s", type, constructorArgTypes, constructorArgs);
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        System.out.println("properties"+ properties);

    }
}
