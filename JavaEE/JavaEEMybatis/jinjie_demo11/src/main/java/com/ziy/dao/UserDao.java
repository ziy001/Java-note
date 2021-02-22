package com.ziy.dao;

import com.ziy.domain.User;

import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/18
 */
public interface UserDao {
    /**
     * 查找所有
     * @return
     */
    List<User> findAll();

    
}
