package com.hengyunsoft.platform.controller.sso;


public class SSOLoginUser {

	/**
	 * 是否登录成功
	 */
	private Boolean logined;
	/**
	 * 用户id
	 */
	private String userid;
	private String account;
	/**
	 * 头像
	 */
	private String photo;
	private String name; 
	/**
	 * 登录错误编码
	 */
	private String errorCode;
	/**
	 * 登录错误消息
	 */
	private String errorMsg;
	/**
	 * 调用网关api需要的token
	 */
	private String token;
	/**
	 * 管理的应用集合
	 */
	private Long adminAppids;
	private int loginCycleFlag;
	
	//public String getToken() {
	//	return token;
	//}

	public String getErrorMsg() {
		return errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public Boolean getLogined() {
		return logined;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public String getAccount() {
		return account;
	}

	public String getName() {
		return name;
	}
	
	public Long getAdminAppids() {
		return adminAppids;
	}

	public static SSOLoginUser loginOk(String userid, String authToken,String account,String name, Long adminAppids, int loginCycleFlag,String photo) {
		SSOLoginUser loginUser = new SSOLoginUser();
		loginUser.userid = userid;
		loginUser.logined = Boolean.TRUE;
		loginUser.token = authToken;
		loginUser.account = account ;
		loginUser.name = name;
		loginUser.adminAppids = adminAppids;
		loginUser.loginCycleFlag = loginCycleFlag;
		loginUser.photo = photo;
		return loginUser;
	}
	
	public static final SSOLoginUser unLogin = new SSOLoginUser();
	
	static {
		unLogin.logined = Boolean.FALSE;
	}

	public String getToken() {
		return token;
	}

	public int getLoginCycleFlag() {
		return loginCycleFlag;
	}

	public String getPhoto() {
		return photo;
	}
}
