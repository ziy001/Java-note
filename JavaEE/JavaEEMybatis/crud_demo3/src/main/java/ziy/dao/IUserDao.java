package ziy.dao;

import ziy.domain.User;


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

}
