package com.hengyunsoft.sec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 一般的md5加密算法，与别人的md5是相同的
 * 将密码进行MD5加密处理
 */
public class MD5Utils {


	private static final String ALGORITHM_MD5 = "MD5";

	/**
	 * Encrypt the password with MD5
	 * 
	 * @param pass
	 *            the password to encryption
	 * @return encryption string
	 */
	protected static String getPassMD5(String pass) {
		String keys = null;
		try {
			MessageDigest md = MessageDigest.getInstance(ALGORITHM_MD5);
			if (pass == null) {
				pass = "";
			}
			byte[] bPass = pass.getBytes();
			md.update(bPass);
			// keys = new String(md.digest(), "GBK");
			keys = bytesToHexString(md.digest());
		} catch (NoSuchAlgorithmException aex) {
			aex.printStackTrace();
		}
		return keys;
	}

	/**
	 * 将beye[]转换为十六进制字符串
	 * 
	 * @param bArray
	 * @return
	 */
	protected static final String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2) {
				sb.append(0);
			}
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}
	
}