package ziy.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ziy.beans.service.Son;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/29
 */
public class MainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("系统获取Son1 "+ctx.getBean("son1"));
        System.out.println("系统获取Son2 "+ctx.getBean("son2")+"   "+ ctx.getBean("son2", Son.class).getAge());

        System.out.println("系统获取theArg1  "+ctx.getBean("theArg1"));
        System.out.println(ctx.getBean("theArg2"));
        System.out.println(ctx.getBean("son3"));

//        ctx.getBean("method1");
    }
}
