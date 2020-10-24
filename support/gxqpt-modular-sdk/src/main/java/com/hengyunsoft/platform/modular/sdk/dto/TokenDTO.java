package com.hengyunsoft.platform.modular.sdk.dto;

/**
 * token实体类
 *
 * @author zhoukx
 * @createTime 2018-4-26
 */
public class TokenDTO {

    /**
     * token
     */
    private String token;
    /**
     * 有效时间：单位：秒
     */
    private Integer expire;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }
}

