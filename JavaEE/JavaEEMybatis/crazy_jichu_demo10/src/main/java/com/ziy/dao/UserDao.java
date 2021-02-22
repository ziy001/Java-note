package com.ziy.dao;

import com.ziy.domain.UserMapper;

import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/14
 */
public interface UserDao {
    /**
     * 查找全部
     * @return
     */
    List<UserMapper> findAll();
}
