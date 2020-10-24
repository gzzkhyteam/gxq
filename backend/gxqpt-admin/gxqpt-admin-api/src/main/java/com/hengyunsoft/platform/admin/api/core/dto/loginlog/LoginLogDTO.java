package com.hengyunsoft.platform.admin.api.core.dto.loginlog;

import java.util.Date;

public class LoginLogDTO  {
    /**
     * 登录应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 登录应用名称
     *
     * @mbggenerated
     */
    private String appName;

    /**
     * 登录人
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 登录人名称
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * 登录时间
     *
     * @mbggenerated
     */
    private Date loginTime;

    /**
     * 退出时间
     *
     * @mbggenerated
     */
    private Date logoutTime;

    /**
     * 主要登录（进入我们系统需要输入密码那一次，当用户登录其中一个系统后，后续的系统将不再进行登录，除非退出。）
     *
     * @mbggenerated
     */
    private Boolean masterLoginIs;

    /**
     * 主要登录id
     *
     * @mbggenerated
     */
    private Long masterLoginId;

    /**
     * 登陆ip地址
     *
     * @mbggenerated
     */
    private String loginIp;
    
    /**
     * 登录账号
     *
     * @mbggenerated
     */
    private String account;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	public Boolean getMasterLoginIs() {
		return masterLoginIs;
	}

	public void setMasterLoginIs(Boolean masterLoginIs) {
		this.masterLoginIs = masterLoginIs;
	}

	public Long getMasterLoginId() {
		return masterLoginId;
	}

	public void setMasterLoginId(Long masterLoginId) {
		this.masterLoginId = masterLoginId;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}