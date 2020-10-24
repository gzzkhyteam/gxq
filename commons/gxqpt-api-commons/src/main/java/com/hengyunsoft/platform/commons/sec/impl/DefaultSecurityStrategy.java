package com.hengyunsoft.platform.commons.sec.impl;

import com.hengyunsoft.platform.commons.sec.BitEncrypt;
import com.hengyunsoft.platform.commons.sec.ISecurityStrategy;

public class DefaultSecurityStrategy implements ISecurityStrategy {

	@Override
	public String encrypt(String salt, String txt) {
		
		if(salt == null || salt.length() < 1) {
			throw new IllegalArgumentException("盐值不允许是空字符串");
		}
		if(txt == null || txt.length() < 1) {
			throw new IllegalArgumentException("加密文本不允许是空字符串");
		}
		
		String code = salt + txt;
		return BitEncrypt.encoding(code);
	}

	@Override
	public String uncrypt(String salt, String encrypt) {
		
		String code = BitEncrypt.unencoding(encrypt);
		return code.substring(salt.length());
	}
	
	public static void main(String[] args) {
		
		DefaultSecurityStrategy s = new DefaultSecurityStrategy();
		
		String en = s.encrypt("569856322", "我爱你");
		
		System.out.println(en);
		
		System.out.println(s.uncrypt("569856322", en));
	}

}
