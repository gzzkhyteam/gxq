package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;
/**
 * 全局使用的异常   一些通用异常。
 * 异常编码范围：  100000-110000
 * @author Administrator
 *
 */
public enum GlobalExceptionCode implements BaseExceptionCode {
	
	SERVER_BUSY(100000,"服务器繁忙，请稍后再试");

	int code;
	String msg;
	private GlobalExceptionCode(int code, String msg) {
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
