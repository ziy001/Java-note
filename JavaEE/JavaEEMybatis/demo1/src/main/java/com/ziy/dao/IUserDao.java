package com.ziy.dao;

import com.ziy.domain.UserMapper;
import com.ziy.mybatis.annotation.Select;

import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/29
 * TODO:dao层接口
 */
public interface IUserDao {
    
    @Select("select * from person")
    List<UserMapper> findAll();
}
