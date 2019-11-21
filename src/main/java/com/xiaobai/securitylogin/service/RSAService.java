package com.xiaobai.securitylogin.service;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

/**
 * RSA相关操作service
 *
 * @author 小白
 * @date 2019/11/19
 */
public interface RSAService {
    /**
     * 生成密钥对
     * @param request servlet请求对象
     * @return 公钥
     * @throws NoSuchAlgorithmException 异常
     */
    String generateKey(HttpServletRequest request) throws NoSuchAlgorithmException;
    /**
     * 加密
     * @param message 明文
     * @param publickey 公钥
     * @return 密文
     * @throws Exception 异常
     */
    String encrypt(String message, String publickey) throws Exception;

    /**
     * 解密
     * @param cipherText 密文
     * @param request servlet请求对象
     * @return 明文
     * @throws Exception 异常
     */
    String decrypt(String cipherText, HttpServletRequest request) throws Exception;
}
