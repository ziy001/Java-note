package com.ziy.factory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/11
 */
public class BeanFactory {
    private static Map<String, Object> map;
    private static Properties props;
    //读取配置文件
    static {
        props = new Properties();
        try(InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties")) {
            props.load(in);
            map = new HashMap<>();
            Set<Object> objects = props.keySet();
            for (Object object : objects) {
                Object o = Class.forName(props.getProperty((String) object)).getDeclaredConstructor().newInstance();
                map.put((String) object, o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Object get(String classPath) {
        Object oo = map.get(classPath);
        return oo;
    }
}
