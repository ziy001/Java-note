package com.ziy.dao;

import com.ziy.domain.User;
import com.ziy.querycondition.QueryVo;

import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/30
 */
public interface IUserDao {
    /**
     * 查询所有
     * @return List
     */
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 根据用户名模糊查询
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 根据id个数 查询用户个数
     * @return
     */
    int findTotal();

    /**
     * 根据条件查询结果
     * @param vo
     * @return
     */
    List<User> findByVo(QueryVo vo);

    /**
     * 用于保存账户信息
     * @param user
     */
    void saveUser(User user);

    /**
     * 用于更新账户信息
     * @param user
     */
    void update(User user);

    /**
     * 根据传入id删除指定账户
     * @param id
     */
    void delete(Integer id);
}
