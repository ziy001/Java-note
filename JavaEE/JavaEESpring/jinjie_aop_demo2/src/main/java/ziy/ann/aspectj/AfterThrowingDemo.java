package ziy.ann.aspectj;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author ziy
 * @version 1.0
 * @date 上午10:31 2020/10/22
 * @description TODO:
 * @className AfterThrowingDemo
 */
@Aspect
public class AfterThrowingDemo {
    @AfterThrowing(pointcut = "ziy.ann.aspectj.Custom.myPointcut1()", throwing = "ex")
    private void printThrow(Throwable ex) {
        System.out.println("====模拟异常处理："+ex.getMessage()+" ====");
    }
}
