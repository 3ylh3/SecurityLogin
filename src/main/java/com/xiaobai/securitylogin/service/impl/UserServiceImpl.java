package com.xiaobai.securitylogin.service.impl;

import com.xiaobai.securitylogin.bean.UserInfoDO;
import com.xiaobai.securitylogin.dao.UserInfoMapper;
import com.xiaobai.securitylogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户相关操作实现类
 *
 * @author 小白
 * @date 2019/11/26
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean register(UserInfoDO userInfoDO) {
        int rs = userInfoMapper.insert(userInfoDO);
        if(1 != rs) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean checkUserPass(String username, String reqPass) {
        UserInfoDO userInfoDO = userInfoMapper.selectByUsername(username);
        if(null == userInfoDO) {
            return false;
        }
        if(reqPass.equals(userInfoDO.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
