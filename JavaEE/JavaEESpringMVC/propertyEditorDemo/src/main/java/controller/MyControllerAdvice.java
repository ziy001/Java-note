package controller;

import bean.DateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午7:31 2020/11/30
 * @description TODO:
 * @className MyControllerAdvice
 */
@ControllerAdvice
public class MyControllerAdvice {
    @ModelAttribute
    public int model() {
        System.out.println("modelAttribute...");
        return 1;
    }
    @InitBinder
    public void initBind(WebDataBinder binder) {
        System.out.println("init...");
        binder.registerCustomEditor(Date.class, new DateEditor());
    }
}
