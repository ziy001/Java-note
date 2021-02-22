package controller;

import bean.Book;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午7:58 2020/11/23
 * @description TODO:
 * @className RESTfulController
 */
@Controller
@RequestMapping("/RESTful")
public class RESTfulController {
    @ResponseBody
    @RequestMapping("/m1")
    public String method1() {
        System.out.println("---method1---");
        return "success";
    }
    @RequestMapping("/m2")
    public HttpEntity method2() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.COOKIE, "10010");
        headers.add(HttpHeaders.CONTENT_TYPE, "text/html; charset=utf-8");
        return new ResponseEntity("调用m2成功", headers, HttpStatus.OK);
    }
    @RequestMapping("/m3")
    @ResponseBody
    public Object method3() {
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_TYPE,
                "application/json; charset=utf-8");
        header.add(HttpHeaders.COOKIE, "10010");
        //创建book并返回json
        Book book = new Book();
        book.setAuthor("ziy");
        book.setBookName("《风跨过的地方》");
        book.setDocument("风跨过的地方是温暖还是寒冷。");
        return new ResponseEntity(book, header, HttpStatus.OK);
//        return book;
//        return List.of(book);
    }
}
