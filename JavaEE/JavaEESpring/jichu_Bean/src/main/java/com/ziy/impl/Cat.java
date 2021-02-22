package com.ziy.impl;

import com.ziy.Being;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/27
 */
public class Cat implements Being {
    private Dog dog;
    private Cat() {
        System.out.print("构造Cat");
        System.out.println("  "+ this);
    }
    @Override
    public void say() {
        System.out.println("猫！！");
    }
}
