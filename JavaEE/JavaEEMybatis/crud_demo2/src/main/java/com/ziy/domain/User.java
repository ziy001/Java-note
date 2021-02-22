package com.ziy.domain;

import java.io.Serializable;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/30
 */
public class User implements Serializable {
    private Integer id;
    private String username;
    private String userpassword;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
