package com.ziy.domain;

import java.io.Serializable;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/7
 * TODO:账户表的实体类
 */
public class Account implements Serializable {
    private int id;
    private int uid;
    private double money;

    /**
     * 使用一个实例变量保存该账户对应的用户信息
     */
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
