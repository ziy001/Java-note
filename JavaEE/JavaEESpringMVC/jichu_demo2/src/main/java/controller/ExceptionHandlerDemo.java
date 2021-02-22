package controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午12:31 2020/11/28
 * @description TODO:
 * @className ExceptionHandler
 */
@ControllerAdvice
//@RequestMapping("/ee")
public class ExceptionHandlerDemo {
    @ModelAttribute
    public void modelAttribute() {
        System.out.println("运行ModelAttribute");
    }
    @InitBinder
    public void init() {
        System.out.println("运行InitBinder");
    }
    @RequestMapping("/m1")
    public void method1(Model model) {
        System.out.println("method1 --- 被执行");
        model.asMap().forEach((k, v) -> System.out.println(k+" -> "+v));
    }
    @ExceptionHandler({IllegalAccessException.class})
    public String exceptionHandle(Model model, Exception ex) {
        System.out.println("exceptionHandler被执行");
        System.out.println(ex.getMessage());
        model.asMap().forEach((k, v) -> System.out.println(k+" -> "+v));
        return "errorPage";
    }
}
