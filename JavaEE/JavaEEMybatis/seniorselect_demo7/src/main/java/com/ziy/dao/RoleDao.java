package com.ziy.dao;

import com.ziy.domain.Role;

import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/8
 * TODO:角色dao接口
 */
public interface RoleDao {
    /**
     * 查询所有用户的角色
     * @return
     */
    List<Role> findAll();
}
