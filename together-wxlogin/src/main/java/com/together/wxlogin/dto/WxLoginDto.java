package com.together.wxlogin.dto;

import lombok.Data;

/**
 * 小程序登录传入dto
 */
@Data
public class WxLoginDto {
    /**
     * 小程序 appId
     */
    private String appid;
    /**
     * 小程序 appSecret
     */
    private String secret;
    /**
     * 登录时获取的 code
     */
    private String jsCode;
    /**
     * 授权类型，此处只需填写 authorization_code
     */
    private String grantType;

}
