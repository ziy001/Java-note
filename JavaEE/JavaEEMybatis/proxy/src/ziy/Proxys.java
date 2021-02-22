package ziy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/22
 * TODO：创建动态代理的工厂类
 */
public class Proxys {
    /**
     * 目标对象
     */
    private Object target;
    public Proxys(Object target) {
        this.target = target;
    }
    public Object wrap() {
        Class<?>[] interfaces = target.getClass().getInterfaces();
        MainTest o = (MainTest)Proxy.newProxyInstance(target.getClass().getClassLoader(), interfaces, new InvocationHandlerImpl());
        return o;
    }
    private static class InvocationHandlerImpl implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("前置代码");
            Object invoke = method.invoke(proxy, args);
            System.out.println("后置代码");
            return null;
        }
    }
}
