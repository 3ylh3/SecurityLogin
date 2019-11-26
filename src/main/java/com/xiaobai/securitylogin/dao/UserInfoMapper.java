package com.xiaobai.securitylogin.dao;

import com.xiaobai.securitylogin.bean.UserInfoDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户信息表mapper
 *
 * @author 小白
 * @date 2019/11/26
 */
@Repository
public interface UserInfoMapper {
    int insert(UserInfoDO userInfoDO);
    UserInfoDO selectByUsername(@Param("username") String username);
}
