package controller;

import bean.Book;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午12:41 2020/11/30
 * @description TODO:
 * @className IndexController
 */
@Controller
public class IndexController {
    @RequestMapping("/m1")
    @ResponseBody
    public Book method1(Book book, BindingResult bindResult) {
        System.out.println("被运行");
        for (ObjectError error : bindResult.getAllErrors()) {
            System.out.println(error);
        }
        System.out.println("错误输出结束");
        return book;
    }
    @RequestMapping("/m2")
    public void method2() {
        System.out.println("m2被运行");
    }
}
