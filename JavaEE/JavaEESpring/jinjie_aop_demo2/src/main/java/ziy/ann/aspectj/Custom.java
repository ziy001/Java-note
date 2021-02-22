package ziy.ann.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author ziy
 * @version 1.0
 * @date 上午10:32 2020/10/22
 * @description TODO:
 * @className Custom
 */
@Aspect
public class Custom {
    @Pointcut("execution(* ziy.ann.test.A.*(..))")
    protected void myPointcut1() {}
}
