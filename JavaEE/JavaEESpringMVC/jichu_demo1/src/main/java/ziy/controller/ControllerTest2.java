package ziy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ziy.controller.bean.User;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.nio.charset.Charset;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午6:30 2020/11/18
 * @description TODO:ContentNegotiatingViewResolver的示例程序
 * @className ControllerTest2
 */
@Controller
public class ControllerTest2 {

    @Autowired
    ApplicationContext context;
    @GetMapping({"/books", "/books.json"})
    public String method1(Model model , HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(requestURI);
//        System.out.println(context);
        return "books";
//        return "books.json"; //jsp页面404
    }
    @RequestMapping("/register")
    public void method2(User user) {
        System.out.println(user);
    }
    @RequestMapping("/method3")
    public void method3(@RequestParam MultiValueMap<String, String> map) {
        map.forEach((k, v) -> {
            System.out.println(k+ "    " +v);
        });
    }

    @RequestMapping(path="/{url1}")
    public void pathVarTest1(HttpServletRequest request) {
        System.out.println(request.getRequestURI());
        System.out.println("pathUrl接受到了请求");
    }

    /**
     * /login/ziy/s/password
     */
    @RequestMapping(path="/login/{username}/s/{password}")
    public void pathVarTest2(@PathVariable String username, @PathVariable String password) {
        System.out.println("账号信息: "+username+"  "+password);
    }

    /**
     * 只匹配A—Z
     * /login/A-Z
     */
    @RequestMapping(path="/login/{phone:[A-Z]}")
    public void pathVarTest3(@PathVariable String phone) {
        System.out.println("regex账户: "+phone);
    }
}
