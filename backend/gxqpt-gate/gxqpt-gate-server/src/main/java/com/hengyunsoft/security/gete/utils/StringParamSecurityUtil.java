package com.hengyunsoft.security.gete.utils;

public class StringParamSecurityUtil {

	public static String convert(String params) {
		
    	if(params!=null) {
    		params = params.replace("\"", "\\\"");
    		params = params.replace("'", "\\'");
    	}
    	return params;
	}
}
