package com.xiaobai.securitylogin.entity;

import com.xiaobai.securitylogin.entity.base.BaseRspBO;

/**
 * 生成密钥对rspBO
 *
 * @author 小白
 * @date 2019/11/19
 */
public class GenerateKeyRspBO extends BaseRspBO {
    /**
     * 公钥
     */
    private String publicKey;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
