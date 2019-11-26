package com.xiaobai.securitylogin.service;

import com.xiaobai.securitylogin.bean.UserInfoDO;

/**
 * 用户相关操作service
 *
 * @author 小白
 * @date 2019/11/26
 */
public interface UserService {
    boolean register(UserInfoDO userInfoDO);
    boolean checkUserPass(String username, String reqPass);
}
