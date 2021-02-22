package com.ziy.ui;

import com.ziy.impl.Dog;
import com.ziy.impl.TestOne;
import org.springframework.beans.factory.config.PropertyPathFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/27
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Thread.sleep(2000);

        TestOne testOne = ctx.getBean("testOne", TestOne.class);
        TestOne testTwo = ctx.getBean("testOne", TestOne.class);
        System.out.println(testOne == testTwo);
        System.out.println(testOne.getClass());
        System.out.println(testTwo.getClass());
//        PropertyPathFactoryBean
//        System.out.println(testOne.createCat());
//        System.out.println(testTwo.createCat());
        //手动使用close()方法关闭容器
//        ctx.close();
        //注册JVM关闭钩子
        ctx.registerShutdownHook();

    }
}
