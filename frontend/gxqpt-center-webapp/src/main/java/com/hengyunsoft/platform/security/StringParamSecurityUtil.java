package com.hengyunsoft.platform.security;

public class StringParamSecurityUtil {

	public static String convert(String params) {
		
    	if(params!=null) {
    		params = params.replace("\"", "");
    		params = params.replace("'", "");
    		
    		params.replace("<", "");
    		params.replace(">", "");
    	}
    	return params;
	}
}
