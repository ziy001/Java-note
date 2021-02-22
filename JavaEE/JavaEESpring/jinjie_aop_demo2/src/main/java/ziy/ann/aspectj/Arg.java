package ziy.ann.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author ziy
 * @version 1.0
 * @date 下午5:56 2020/10/22
 * @description TODO:
 * @className Arg
 */
@Aspect
public class Arg {
//    @Before(value = "execution(* ziy.ann.test.B.*(..)) && args(name, age, obj)", argNames = "name, age, obj")
//    public void arg(String name, int age, Object obj) {
//        System.out.println("====增强处理====");
//        System.out.println(name);
//    }
//    @After(value = "execution(* ziy.ann.test.B.*(..)) && args(String, int, Object)")
//    public void arg2() {
//        System.out.println("====增强处理2====");
//    }
    @Around(value = "execution(* ziy.ann.test.B.*(..)) && args(name, age, obj)", argNames = "point, name, age, obj")
    public void arg3(ProceedingJoinPoint point, String name, int age, Object obj) throws Throwable {
        System.out.println("arount处理");
        point.proceed(new Object[]{new String("姓名"), 12, new Object()});
        System.out.println(name+" >>>> "+age);
    }
}
