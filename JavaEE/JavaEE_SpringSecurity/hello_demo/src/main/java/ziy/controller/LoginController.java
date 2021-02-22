package ziy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZIY
 * @version 1.0
 * @date 2021/2/20 上午10:29
 * @description TODO:
 * @className LoginController
 */
@Controller
public class LoginController {

    @RequestMapping("/toError")
    public String error() {
        System.out.println("登录失败");
        return "redirect:error.html";
    }
    @RequestMapping("/toMain")
    public String toMain() {
        System.out.println("登录成功");
        return "redirect:main.html";
    }
}
