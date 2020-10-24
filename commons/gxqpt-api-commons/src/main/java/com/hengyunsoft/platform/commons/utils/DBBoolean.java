package com.hengyunsoft.platform.commons.utils;

/**
 * 数据库中的bit 布尔值定义常量
 * @author Administrator
 * 定义了三种类型的布尔值
 * 1.  字符串表示的布尔值
 * 2.  布尔表示的布尔值
 * 3.  数字表示的布尔值
 */
public class DBBoolean {

	public final static String TRUE_STR = "1";
	public final static String FALSE_STR = "0";
	
	public final static Boolean TRUE_BOOL = Boolean.TRUE;
	public final static Boolean FALSE_BOOL = Boolean.FALSE;
	
	public final static Integer TRUE_NUMBER = 1;
	public final static Integer FALSE_NUMBER = 0;
}
