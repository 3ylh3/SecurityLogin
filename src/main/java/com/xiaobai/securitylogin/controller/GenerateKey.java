package com.xiaobai.securitylogin.controller;

import com.xiaobai.securitylogin.common.MsgCdEnum;
import com.xiaobai.securitylogin.entity.GenerateKeyRspBO;
import com.xiaobai.securitylogin.service.RSAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

/**
 * 生成密钥对
 *
 * @author 小白
 * @date 2019/11/19
 */
@RestController
public class GenerateKey {

    @Autowired
    private RSAService rsaService;

    @RequestMapping(value = "/generateKey",method = RequestMethod.POST)
    public GenerateKeyRspBO generateKey(HttpServletRequest request) {
        GenerateKeyRspBO rspBO = new GenerateKeyRspBO();
        try {
            String publicKey =  rsaService.generateKey(request);
            rspBO.setPublicKey(publicKey);
            rspBO.setMsgCd(MsgCdEnum.SUCSS.getMsgCd());
            rspBO.setMsgInf(MsgCdEnum.SUCSS.getMsgInf());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            rspBO.setMsgCd(MsgCdEnum.GENERATE_KEY_ERROR.getMsgCd());
            rspBO.setMsgInf(MsgCdEnum.GENERATE_KEY_ERROR.getMsgInf());
        }

        return rspBO;
    }
}
