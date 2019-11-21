package com.xiaobai.securitylogin.entity;

/**
 * 登录reqBO
 *
 * @author 小白
 * @date 2019/11/21
 */
public class LoginReqBO {
    private String username;
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
