package com.ziy.domain;

import java.io.Serializable;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/14
 * TODO:Person表映射类
 */
public class UserMapper implements Serializable {
    private int id;
    private String userName;
    private String userPassword;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserMapper{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
