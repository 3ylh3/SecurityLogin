package com.xiaobai.securitylogin.entity.base;

/**
 * 基础rspBO
 *
 * @author 小白
 * @date 2019/11/19
 */
public class BaseRspBO {
    /**
     * 返回信息
     */
    private String msgCd;
    /**
     * 返回码
     */
    private String msgInf;

    public String getMsgCd() {
        return msgCd;
    }

    public String getMsgInf() {
        return msgInf;
    }

    public void setMsgCd(String msgCd) {
        this.msgCd = msgCd;
    }

    public void setMsgInf(String msgInf) {
        this.msgInf = msgInf;
    }
}
