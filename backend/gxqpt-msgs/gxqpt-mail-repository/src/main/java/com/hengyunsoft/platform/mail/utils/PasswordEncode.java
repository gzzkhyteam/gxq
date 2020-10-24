package com.hengyunsoft.platform.mail.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.mail.internet.MimeUtility;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 类说明：密码的加密与解密
 * 
 * @author 作者: LiuJunGuang
 * @version 创建时间：2011-5-19 下午11:07:09
 */
public class PasswordEncode {
	private static String pwdAlgorithm = "MD5";

	/**
	 * 无参的构造方法--密码加密
	 */
	public PasswordEncode() {
		super();
	}

	/**
	 * 加密文件算法
	 * 
	 * @param filename
	 *            需要加密的文件名
	 * @param algorithm
	 *            加密算法名
	 */
	public static void digestFile(String filename, String algorithm) {
		byte[] b = new byte[65536];
		int count = 0;
		int read = 0;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			fis = new FileInputStream(filename);
			while (fis.available() > 0) {
				read = fis.read(b);
				md.update(b, 0, read);
				count += read;
			}
			byte[] digest = md.digest();
			StringBuffer fileNameBuffer = new StringBuffer(128)
					.append(filename).append(".").append(algorithm);
			fos = new FileOutputStream(fileNameBuffer.toString());
			OutputStream encodedStream = MimeUtility.encode(fos, "base64");
			encodedStream.write(digest);
			fos.flush();
		} catch (Exception e) {
			System.out.println("Error computing Digest: " + e);
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (Exception ignored) {
			}
		}
	}

	/**
	 * 加密密码算法
	 * 
	 * @param pass
	 *            需要加密的原始密码
	 * @param algorithm
	 *            加密算法名称
	 * @return 加密后的密码
	 * @throws NoSuchAlgorithmException
	 *             当加密算法不可用时抛出此异常
	 */
	public static String digestString(String password, String alg)
			throws NoSuchAlgorithmException {
		String newPass;
		if (alg == null || alg.equals("MD5")) {
			newPass = DigestUtils.md5Hex(password);
		} else if (alg.equals("NONE")) {
			newPass = "password";
		} else if (alg.equals("SHA-256")) {
			newPass = DigestUtils.sha256Hex(password);
		} else if (alg.equals("SHA-512")) {
			newPass = DigestUtils.sha512Hex(password);
		} else {
			newPass = DigestUtils.shaHex(password);
		}
		return newPass;
	}

	/**
	 * 加密密码算法
	 * 
	 * @param newPass
	 *            未加密的密码
	 * @param algorithm
	 *            加密算法
	 * @return String 加密后的密码
	 */
	public static String setPassword(String newPass) {
		try {
			if (newPass != null && !"".equals(newPass)) {
				return digestString(newPass, pwdAlgorithm);
			} else
				return null;
		} catch (NoSuchAlgorithmException nsae) {
			throw new RuntimeException("Security error: " + nsae);
		}
	}

	/**
	 * 判断密码是不是相当
	 * 
	 * @param beforePwd
	 *            要判断的密码
	 * @param afterPwd
	 *            加密后的数据库密码
	 * @return Boolean true 密码相等
	 */
	public static boolean isPasswordEnable(String beforePwd, String afterPwd) {
		if (beforePwd != null && !"".equals(beforePwd)) {
			String password = setPassword(beforePwd);
			return afterPwd.equals(password);
		} else
			return false;
	}
}
