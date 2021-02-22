package proxy;

import java.lang.reflect.Proxy;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/20
 */
public class MyProxyFactory {
    public static Object accept(Object target) {
        MyInvocationHandler myi = new MyInvocationHandler();
        myi.setTarget(target);
        //创建动态代理
        Object proxy = Proxy
                .newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), myi);
        return proxy;
    }
}
