package ziy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ZIY
 * @version 1.0
 * @date 2021/1/6 下午8:44
 * @description TODO:主程序类
 * @className Main
 */

//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("ziy")
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(Main.class, args);
    }
}
