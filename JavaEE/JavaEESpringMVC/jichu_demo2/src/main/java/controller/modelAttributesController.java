package controller;

import bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午3:24 2020/11/23
 * @description TODO:
 * @className modelAttributesController
 */
@Controller
@RequestMapping("/model")
@ResponseBody
public class modelAttributesController {
    @ModelAttribute("m1")
    public String m1() {
        System.out.println("----m1----");
        return "method1";
    }
    @ModelAttribute("m2")
    public void m2() {
        System.out.println("----m2----");
    }
    @ModelAttribute("m3")
    public int m3() {
        System.out.println("----m3----");
        return 3;
    }
    @RequestMapping("/test1")
    public String test1(Model model) {
        System.out.println("----test1----");
        model.asMap().forEach((k, v) -> System.out.println(k+"  ->  "+v));
        return "d1";
    }
    @RequestMapping("/test2")
    public String test2(@ModelAttribute Book book, Model model) {
        System.out.println("----test2----");
        model.asMap().forEach((k, v) -> System.out.println(k+"  ->  "+v));
        return "d1";
    }
}
