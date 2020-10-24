package com.hengyunsoft.platform.developer.entity.core.domain;

import com.hengyunsoft.platform.developer.entity.core.po.ApplicationHostInstall;

import java.io.Serializable;

public class ApplicationHostInstallDO extends ApplicationHostInstall implements Serializable {
	/**
	 * 主机名
	 *
	 * @mbggenerated
	 */
	private String hostName;

	/**
	 * 应用名
	 *
	 * @mbggenerated
	 */
	private String appName;

	private String applicationName;
	private String userName;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}