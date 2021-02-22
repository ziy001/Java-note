package com.ziy.impl;

import com.ziy.Being;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/27
 */
public class Dog implements Being {
    private Cat cat;
    private Dog() {
        System.out.println("构造Dog");
    }
    @Override
    public void say() {
        System.out.println("狗！！");
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
    private void close() {
        System.out.println(this+" 关闭...");
    }
}
