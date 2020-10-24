package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;
/**
 * 
 * 认证方面的异常编码
 * @author 潘定遥
 *
 */
public enum AuthExceptionCode implements BaseExceptionCode {
    
	ERROR_USER_TOKEN(115001,"错误的用户级token"),
	ERROR_APP_TOKEN(115002,"错误的应用级token");

    private int code;
    private String msg;

    AuthExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
