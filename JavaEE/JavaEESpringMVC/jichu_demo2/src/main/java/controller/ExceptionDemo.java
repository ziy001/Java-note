package controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Random;

/**
 * @author ZIY
 * @version 1.1
 * @date 上午8:24 2020/11/28
 * @description TODO:异常处理
 * @className ExceptionDemo
 */
@Controller
@RequestMapping("/e")
public class ExceptionDemo {
    @RequestMapping("/m1")
    public String method1() throws IllegalAccessException {
        System.out.println("method1被执行");
        if (new Random().nextBoolean()) {
//            throw new IllegalAccessException("测试异常");
            return "d1";
        } else {
          return "d1";
        }
//        return "d1";
    }
}
