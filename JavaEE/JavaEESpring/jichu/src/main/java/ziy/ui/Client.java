package ziy.ui;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ziy.dao.SaveDao;
import ziy.service.impl.SaveServiceImpl;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/25
 */
public class Client {
    public static void main(String[] args) {
        //创建Spring容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        //调用
        SaveServiceImpl service = ctx.getBean("service", SaveServiceImpl.class);
        SaveDao saveDao = service.getSaveDao();
        System.out.println(saveDao);

    }

}
