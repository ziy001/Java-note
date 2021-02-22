package ziy.controller;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ziy.pojo.Pet;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author ZIY
 * @version 1.0
 * @date 2021/1/6 下午8:47
 * @description TODO:
 * @className PageController
 */
@RestController
public class PageController {
    @RequestMapping("/h")
    public String showHello(HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        Iterator<String> iterator = parameterNames.asIterator();
        iterator.forEachRemaining((name) -> {
            System.out.println(name);
        });
        return "Hello,World Spring Boot 2";
    }
    @GetMapping("/pet")
    public Pet showPet(String name, int age, String desc) {
        Pet pet = new Pet();
        pet.setPetName(name);
        pet.setAge(age);
        pet.setDescribe(desc);
        return pet;
    }
}
