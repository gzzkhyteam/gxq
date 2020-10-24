package com.hengyunsoft.platform.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("gxqpt.config")
@Component
public class GxqptWebappConfig {

	private String appId;
	private String appSecret;
	
	/**
	 * 首页地址
	 */
	private String indexUrl;
	/**
	 * 登录url地址
	 */
	private String loginUrl;
	/** 业务系统退出地址 */
	private String logoutUrl ;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getIndexUrl() {
		return indexUrl;
	}
	public void setIndexUrl(String indexUrl) {
		this.indexUrl = indexUrl;
	}
	public String getLoginUrl() {
		return loginUrl;
	}
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	public String getLogoutUrl() {
		return logoutUrl;
	}
	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}
	@Override
	public String toString() {
		return "GxqptWebappConfig [appId=" + appId + ", appSecret=" + appSecret + ", indexUrl=" + indexUrl
				+ ", loginUrl=" + loginUrl + ", logoutUrl=" + logoutUrl + "]";
	}
}
