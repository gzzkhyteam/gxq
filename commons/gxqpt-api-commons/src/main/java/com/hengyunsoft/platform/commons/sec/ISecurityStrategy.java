package com.hengyunsoft.platform.commons.sec;


public interface ISecurityStrategy {

	/**
	 * 
	 * @param salt   加密的盐值
	 * @param txt
	 * @return
	 */
	public String encrypt(String salt,String txt);
	
	public String uncrypt(String salt,String encrypt);
}
