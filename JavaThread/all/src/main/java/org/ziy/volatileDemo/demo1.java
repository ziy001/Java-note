package org.ziy.volatileDemo;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/13
 * TODO:线程可见性（单例模式）
 */
public class demo1 {

}

/**
 * 饿汉式 -- 类初始化就创建好对象，需要使用直接返回对象
 */
class A {
    private static A a = new A();
    private A() {
        //防止反射攻击
        if(a != null) {
            throw new RuntimeException("not create");
        }
    }
    public static A getInstance() {
        return a;
    }
}
/**
 * 懒汉式 -- 需要的时候才创建
 */
class B {
    private static volatile B b= null;
    private B() {
        //防止反射攻击
        if(b != null) {
            throw new RuntimeException();
        }
    }

    public static B getInstance() {
        //业务逻辑代码
        if(b == null) {
            //双重检查 -- 减少线程来获取锁的步骤
            synchronized (B.class) {
                if(b == null) {
                    b = new B();
                }
            }
        }
        return b;
    }
}
