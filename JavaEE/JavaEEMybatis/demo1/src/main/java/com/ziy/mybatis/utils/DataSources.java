package com.ziy.mybatis.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/29
 */
public class DataSources {

    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            DriverManager.getConnection(cfg.getUrl(), cfg.getUserName(), cfg.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
