package ziy.service.impl;

import ziy.service.Service;

import java.util.Objects;

/**
 * @author ziy
 * @version 1.0
 * @date 下午6:55 2020/11/16
 * @description TODO:
 * @className LoginService
 */
public class LoginServiceImpl implements Service {
    private static final String USERNAME = "1";
    private static final String PASSWORD = "1";
    public int checkLogin(String username, String password) {
        if (Objects.equals(username, USERNAME)
                && Objects.equals(password, PASSWORD)) {
            return 19;
        }
        return 0;
    }
}
