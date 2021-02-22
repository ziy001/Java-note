package ziy.xml.aspectj;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author ziy
 * @version 1.0
 * @date 上午10:31 2020/10/22
 * @description TODO:
 * @className AfterThrowingDemo
 */
public class AfterThrowingDemo {
    private void printThrow(Throwable ex) {
        System.out.println("====模拟异常处理："+ex.getMessage()+" ====");
    }
}
