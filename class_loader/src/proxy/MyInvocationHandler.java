package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/20
 */
public class MyInvocationHandler implements InvocationHandler {
    //需要被代理的对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 代理对象
     * @param method 执行的方法
     * @param args 方法的实参
     * @return 方法执行的结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil du = new DogUtil();
        du.method1();
        Object result = method.invoke(target, args);
        du.method2();
        return result;
    }
}
