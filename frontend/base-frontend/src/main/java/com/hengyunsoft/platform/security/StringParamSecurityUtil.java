package com.hengyunsoft.platform.security;

public class StringParamSecurityUtil {

	/**
	 * 过滤特殊字符
	 * @param params
	 * @return
	 */
	public static String filterSpecialCharacter(String params) {
		
    	if(params!=null) {
    		params = params.replace("\"", "");
    		params = params.replace("'", "");
    		params.replace("<", "");
    		params.replace(">", "");
    	}
    	return params;
	}
}
