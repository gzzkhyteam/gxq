package com.hengyunsoft.sec;

public class PasswordEncoder {

	public static String encoder(String str) {
		
		return MD5Utils.getPassMD5(str);
	}
}
