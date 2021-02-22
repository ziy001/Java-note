package ziy.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ziy.service.pack.Person;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/30
 */
public class MainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Person p1 = ctx.getBean("p1", Person.class);
        System.out.println(p1);
    }
}
