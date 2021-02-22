package ziy.ann.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author ziy
 * @version 1.0
 * @date 上午11:08 2020/10/22
 * @description TODO:
 * @className After
 */
@Aspect
public class AfterDemo {
    @After(value = "ziy.ann.aspectj.Custom.myPointcut1()")
    public void after(JoinPoint joinPoint) {
        System.out.println("====After处理");
        for (Object arg : joinPoint.getArgs()) {
            System.out.println(arg);
        }
        System.out.println("====");
    }
}
