package com.ziy.service.impl;

import com.ziy.dao.IAccountDao;
import com.ziy.dao.impl.AccountDaoImpl;
import com.ziy.factory.BeanFactory;
import com.ziy.service.IAccountService;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/28
 * TODO:账户业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
//    private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.get("AccountDao");

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
