package com.ziy.dao.impl;

import com.ziy.dao.IAccountDao;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/28
 * TODO:账户业务服务层
 */
public class AccountDaoImpl implements IAccountDao {
    private int i = 0;
    @Override
    public void saveAccount() {
        System.out.println("保存了一个账户");
        i++;
        System.out.println("存储了 "+ i +" 个账户");
    }
}
