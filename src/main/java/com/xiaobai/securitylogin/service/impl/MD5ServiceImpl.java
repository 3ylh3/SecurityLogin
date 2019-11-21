package com.xiaobai.securitylogin.service.impl;

import com.xiaobai.securitylogin.service.MD5Service;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

/**
 * MD5相关操作实现类
 *
 * @author 小白
 * @date 2019/11/21
 */
@Service
public class MD5ServiceImpl implements MD5Service {
    private static final String ALGORITHM = "MD5";

    @Override
    public String encrypt(String message) throws Exception {
        MessageDigest md = MessageDigest.getInstance(ALGORITHM);
        md.update(message.getBytes("UTF-8"));
        byte[] digest = md.digest();
        //将byte数组的签名结果转为String类型
        StringBuffer hexstr = new StringBuffer();
        String hex = "";
        for (int i = 0; i < digest.length; i++) {
            hex = Integer.toHexString(digest[i] & 0xFF);
            if (hex.length() < 2) {
                hexstr.append(0);
            }
            hexstr.append(hex);
        }
        String result = hexstr.toString();
        return result;
    }
}
