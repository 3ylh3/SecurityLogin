package com.xiaobai.securitylogin.service;

/**
 * MD5相关操作service
 *
 * @author 小白
 * @date 2019/11/21
 */
public interface MD5Service {
    /**
     * 加密
     * @param message 明文
     * @return MD5值
     */
    String encrypt(String message) throws Exception;
}
