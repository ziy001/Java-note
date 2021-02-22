package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.Service;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午10:26 2020/11/26
 * @description TODO:国际化示例程序
 * @className I18NDemo
 */
@Controller
@RequestMapping("/s")
public class I18NDemo {
    @Autowired
    private Service service;
    @PostMapping("/login")
    public String login(String userName, String password) {
        if (service.login(userName, password) >= 0) {
            return "login/success";
        }
        return "login/error";
    }
}
