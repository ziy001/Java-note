package com.ziy.domain;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/18
 */
public class User implements Serializable {
    private int id;
    private String userName;
    private LocalDateTime birthday;
    private String sex;
    private String address;
    private Account account;
    public User(){}

    public User(String userName) {
        this.userName = userName;
    }

    public User(@Param("id") Integer id, @Param("userName") String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

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

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        String birthday = this.birthday.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
