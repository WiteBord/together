package com.together.wxlogin.dto;

import lombok.Data;

/**
 * 小程序登录返回
 */
@Data
public class WxResultDto {

    /**
     *用户唯一标识
     */
    private String openid;
    /**
     *会话密钥
     */
    private String sessionKey;
    /**
     *用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回，详见 UnionID
     */
    private String unionid;
    /**
     *错误码
     */
    private String errcode;
    /**
     *错误信息
     */
    private String errmsg;
}
