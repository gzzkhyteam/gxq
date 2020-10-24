package com.hengyunsoft.security.auth.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tyh
 * @createTime 2017-12-15 11:58
 */
@Data
public class JwtAuthRequest implements Serializable{
    private String userName;
    private String passWord;

    public JwtAuthRequest() {
    }

    public JwtAuthRequest(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
}
