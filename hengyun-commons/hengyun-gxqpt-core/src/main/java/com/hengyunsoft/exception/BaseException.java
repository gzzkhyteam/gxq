package com.hengyunsoft.exception;

/**
 * 异常接口类
 * 
 * @author loujingying@hengyunsoft.com
 * @version 1.1.1, 2016-03-31
 * @since 1.1.1
 */
public interface BaseException {

	/**
	 * 返回异常信息
	 * @return
	 */
	String getMessage();

	/**
	 * 返回异常编码
	 * @return
	 */
	int getCode();

}
