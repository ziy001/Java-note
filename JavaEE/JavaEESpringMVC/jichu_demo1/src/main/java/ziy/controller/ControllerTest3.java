package ziy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午3:28 2020/11/20
 * @description TODO:
 * @className ControllerTest3
 */
@Controller
@RequestMapping("/test3")
public class ControllerTest3 {
    @RequestMapping("/method1")
    public void method1(@RequestParam MultiValueMap<String, String> map) {
        System.out.println("test3/method1接受到请求");
        map.forEach((k, v) -> {
            System.out.println(k+"    "+v);
        });
    }
    @RequestMapping(path = "/owners/{ownerId}/pets/{petId}")
    public void method2(@PathVariable Integer ownerId, @PathVariable Integer petId,
                        @MatrixVariable(name = "q", pathVar = "ownerId") String q1,
                        @MatrixVariable(name = "q", pathVar = "petId") String q2) {
        System.out.println("{"+ ownerId + petId + q1 + q2 +"}");
    }
}
