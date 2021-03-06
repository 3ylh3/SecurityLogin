package com.xiaobai.securitylogin.common;

/**
 * 错误码枚举
 *
 * @author 小白
 * @date 2019/11/19
 */
public enum MsgCdEnum {
    // 成功
    SUCSS("0000","成功"),
    GENERATE_KEY_ERROR("0001","生成密钥对异常"),
    LOGIN_ERROR("0002","登录失败"),
    REGISTER_ERROR("0003", "注册失败"),
    PSWD_ERROR("0004","用户名或密码错误");

    private String msgCd;
    private String msgInf;

    MsgCdEnum(String msgCd, String msgInf) {
        this.msgCd = msgCd;
        this.msgInf = msgInf;
    }

    public String getMsgCd() {
        return msgCd;
    }

    public String getMsgInf() {
        return msgInf;
    }
}
