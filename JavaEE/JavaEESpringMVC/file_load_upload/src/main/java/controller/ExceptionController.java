package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午10:30 2020/12/5
 * @description TODO:
 * @className ExceptionController
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(IOException.class)
    public String ioException() {
        return "error";
    }
}
