package com.ziy.dao;

import com.ziy.domain.Account;

import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/8
 * TODO:账户Dao接口
 */
public interface AccountDao {
    /**
     * 查询所有账户信息
     * @return
     */
    List<Account> findAll();
}
