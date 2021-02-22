package service.impl;

import service.Service;

import java.util.Objects;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午10:29 2020/11/26
 * @description TODO:
 * @className LoginServiceImpl
 */
public class LoginServiceImpl implements Service {
    private String userName = "ziy001";
    private String password = "10010";
    @Override
    public int login(String userName, String password) {
        boolean b = Objects.equals(userName, this.userName) && Objects.equals(password, this.password);
        if (b) {
            return 19;
        }
        return -1;
    }
}
