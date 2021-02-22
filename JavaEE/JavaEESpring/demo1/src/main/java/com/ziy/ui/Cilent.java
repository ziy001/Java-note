package com.ziy.ui;

import com.ziy.factory.BeanFactory;
import com.ziy.service.impl.AccountServiceImpl;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/28
 */
public class Cilent {
    public static void main(String[] args) {
//        AccountServiceImpl accountService = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            AccountServiceImpl accountService = (AccountServiceImpl) BeanFactory.get("AccountService");
            accountService.saveAccount();
        }
    }
}
