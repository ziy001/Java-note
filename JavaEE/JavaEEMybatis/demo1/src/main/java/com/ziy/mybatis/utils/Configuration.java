package com.ziy.mybatis.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/29
 * TODO:封装了从XML分析出来的数据
 */
public class Configuration {
    private String driver;
    private String url;
    private String userName;
    private String password;
    private Map<String, Mapper> mappers = new HashMap<>();

    public Map getMappers() {
        return mappers;
    }

    public void setMappers(Map<String,Mapper> mappers) {
        this.mappers.putAll(mappers);
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
