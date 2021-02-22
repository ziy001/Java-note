package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午8:45 2020/11/20
 * @description TODO:
 * @className AsyncController
 */
@Controller
@RequestMapping("/async")
public class AsyncController {
    @RequestMapping("/callable")
    public Callable callableTest() {
        System.out.println("主线程开始，线程id为: "+Thread.currentThread().getId());
        Callable result = () -> {
            System.out.println("新线程开始，id: "+Thread.currentThread().getId());
            Thread.sleep(10000);
            System.out.println("新线程结束，id: "+Thread.currentThread().getId());
            return "d1";
        };
        System.out.println("主线程结束，线程id为: "+Thread.currentThread().getId());
        return result;
    }
    @RequestMapping("/deferred")
    public DeferredResult deferredResultTest() throws InterruptedException {
        System.out.println("主线程开始，线程id为: "+Thread.currentThread().getId());
        //创建DeferredResult
        /*
        timeoutValue:传入超时时长
        timeoutResult:超时之后的逻辑视图
         */
        DeferredResult result = new DeferredResult();
//        new Thread(() -> {
//            System.out.println("新线程开始，id: "+Thread.currentThread().getId());
//            try {
//                Thread.sleep(15000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("新线程结束，id: "+Thread.currentThread().getId());
//            result.setErrorResult("d1");
//        }).start();
        System.out.println("主线结束，线程id为: "+Thread.currentThread().getId());
        return result;
    }
}
