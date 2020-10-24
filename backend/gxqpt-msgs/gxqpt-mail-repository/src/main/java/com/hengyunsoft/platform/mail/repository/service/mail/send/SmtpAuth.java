package com.hengyunsoft.platform.mail.repository.service.mail.send;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 用户身份认证类
 * 
 * @author 作者：user
 * @version 创建时间：2011-7-19 下午04:33:02
 */
public class SmtpAuth extends Authenticator {
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;

	/**
	 * 用户认证类的初始化
	 * 
	 * @param user
	 *            用户名
	 * @param password
	 *            密码
	 */
	public SmtpAuth(String user, String password) {
		this.username = user;
		this.password = password;
	}

	/**
	 * 得到用户认证信息
	 */
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
