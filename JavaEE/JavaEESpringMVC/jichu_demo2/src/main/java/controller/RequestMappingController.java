package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午4:52 2020/11/19
 * @description TODO:
 * @className RequestMappingController
 */
@Controller
@RequestMapping("/demo1")
public class RequestMappingController {
    @RequestMapping(value = "/d1", params =  "name")
    public void test(String name) {
        System.out.println("d1接收到了请求   "+ name);
        /**
         * void：默认返回请求路径作为参数返回    "/demo1/d1"
         */
    }
}
