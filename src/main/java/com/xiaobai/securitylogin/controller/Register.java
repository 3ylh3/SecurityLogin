package com.xiaobai.securitylogin.controller;

import com.xiaobai.securitylogin.common.MsgCdEnum;
import com.xiaobai.securitylogin.entity.RegisterReqBO;
import com.xiaobai.securitylogin.entity.RegisterRspBO;
import com.xiaobai.securitylogin.service.MD5Service;
import com.xiaobai.securitylogin.service.RSAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 注册
 *
 * @author 小白
 * @date 2019/11/21
 */
@RestController
public class Register {

    @Autowired
    private RSAService rsaService;
    @Autowired
    private MD5Service md5Service;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RegisterRspBO register(@RequestBody RegisterReqBO reqBO, HttpServletRequest request) {
        RegisterRspBO rspBO = new RegisterRspBO();
        try {
            String password = rsaService.decrypt(reqBO.getPassword(), request);
            String passMd5 = md5Service.encrypt(password);
            System.out.println("password:" + password);
            System.out.println("password md5:" + passMd5);

            // TODO 将用户信息入库

            rspBO.setMsgCd(MsgCdEnum.SUCSS.getMsgCd());
            rspBO.setMsgInf(MsgCdEnum.SUCSS.getMsgInf());
        } catch (Exception e) {
            e.printStackTrace();
            rspBO.setMsgCd(MsgCdEnum.REGISTER_ERROR.getMsgCd());
            rspBO.setMsgInf(MsgCdEnum.REGISTER_ERROR.getMsgInf());
        }

        return rspBO;
    }
}
