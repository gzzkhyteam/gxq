package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

public enum CenterExceptionCode implements BaseExceptionCode {
	MUST_APP_INFO(30000,"应用app信息不允许为空");

	private int code;
    private String msg;

    CenterExceptionCode(int code, String msg) {
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
