package com.ziy.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/9/8
 */
public class Role implements Serializable {
    private int id;
    private String roleName;
    private String roleDesc;

    private List<User> users;

    public List<User> getUser() {
        return users;
    }

    public void setUser(List<User> user) {
        this.users = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
