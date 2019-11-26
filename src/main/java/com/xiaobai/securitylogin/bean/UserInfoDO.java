package com.xiaobai.securitylogin.bean;

/**
 * 用户表DO
 *
 * @author 小白
 * @date 2019/11/26
 */
public class UserInfoDO {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
