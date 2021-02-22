package ziy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import ziy.service.Service;
import ziy.service.impl.LoginServiceImpl;

import javax.annotation.Resource;

/**
 * @author ziy
 * @version 1.0
 * @date 上午11:03 2020/11/16
 * @description TODO:控制器
 * @className Login
 */
@Controller
public class ControllerTest {
    @Resource
    private LoginServiceImpl loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public View page1(String username, String pass, RedirectAttributes attrs) {
        System.out.println(username+"    "+pass);
        if (loginService.checkLogin(username, pass) > 0) {
            attrs.addFlashAttribute("tip", "账号正确，成功登录");
            return new RedirectView("success");
        }
        attrs.addFlashAttribute("tip", "账号错误,登录失败");
        return new RedirectView("fail");
    }
    @GetMapping("/success")
    public String success(@ModelAttribute("tip") String tip) {
        System.out.println("success获取的值: "+tip);
        return "success";
    }
    @GetMapping("/fail")
    public String fail(@ModelAttribute("tip") String tip) {
        System.out.println("fail获取的值: "+tip);
        return "fail";
    }
}
