package ziy.xml.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author ziy
 * @version 1.0
 * @date 上午11:49 2020/10/22
 * @description TODO:
 * @className AroundDemo
 */
public class AroundDemo {
    private void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        proceedingJoinPoint.proceed();
    }
}
