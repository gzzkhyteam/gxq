package com.hengyunsoft.platform.controller.sso;

import com.hengyunsoft.platform.commons.sec.BitEncrypt;

public class AppInfoEncoder {

	private final static  char  separator = '_';

	public static String encoder(String appId,String appSecret) {
		StringBuilder text = new StringBuilder(appId.length()+3+appSecret.length());
		text.append(appId.length());
		text.append(separator);
		text.append(appId);
		text.append(appSecret);
		return BitEncrypt.encoding(text.toString());
	}
	
	public static String[] uncoder(String text) {
		
		String untext = BitEncrypt.unencoding(text);
		int index = untext.indexOf(separator);
		int appIdLength = Integer.parseInt(untext.substring(0, index));
		String[] appId2AppSecret = new String[2];
		appId2AppSecret[0] = untext.substring(index+1,index+1+appIdLength);
		appId2AppSecret[1] = untext.substring(index+1+appIdLength);
		return appId2AppSecret;
	}
	
	public static String getAppId(String[] appId2AppSecret) {
		return appId2AppSecret[0];
	}
	public static String getAppSecret(String[] appId2AppSecret) {
		return appId2AppSecret[1];
	}
}
