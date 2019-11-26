package com.xiaobai.securitylogin.controller;

import com.xiaobai.securitylogin.common.MsgCdEnum;
import com.xiaobai.securitylogin.entity.LoginReqBO;
import com.xiaobai.securitylogin.entity.LoginRspBO;
import com.xiaobai.securitylogin.service.MD5Service;
import com.xiaobai.securitylogin.service.RSAService;
import com.xiaobai.securitylogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录
 *
 * @author 小白
 * @date 2019/11/21
 */
@RestController
public class Login {

    @Autowired
    private RSAService rsaService;
    @Autowired
    private MD5Service md5Service;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginRspBO login(@RequestBody LoginReqBO reqBO, HttpServletRequest request) {
        LoginRspBO rspBO = new LoginRspBO();
        try {
            String password = rsaService.decrypt(reqBO.getPassword(),request);
            String passMd5 = md5Service.encrypt(password);

            boolean rs = userService.checkUserPass(reqBO.getUsername(),passMd5);
            if(rs) {
                rspBO.setMsgCd(MsgCdEnum.SUCSS.getMsgCd());
                rspBO.setMsgInf(MsgCdEnum.SUCSS.getMsgInf());
            } else {
                rspBO.setMsgCd(MsgCdEnum.PSWD_ERROR.getMsgCd());
                rspBO.setMsgInf(MsgCdEnum.PSWD_ERROR.getMsgInf());
            }
        } catch (Exception e) {
            e.printStackTrace();
            rspBO.setMsgCd(MsgCdEnum.LOGIN_ERROR.getMsgCd());
            rspBO.setMsgInf(MsgCdEnum.LOGIN_ERROR.getMsgInf());
        }
        return rspBO;
    }
}
