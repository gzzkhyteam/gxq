package com.hengyunsoft.sso.authentication;

public class SSOConfig {

	private String loadUserApi;
	private String randomStr;
	public String getLoadUserApi() {
		return loadUserApi;
	}
	public void setLoadUserApi(String loadUserApi) {
		this.loadUserApi = loadUserApi;
	}
	public String getRandomStr() {
		return randomStr;
	}
	public void setRandomStr(String randomStr) {
		this.randomStr = randomStr;
	}
	@Override
	public String toString() {
		return "SSOConfig [loadUserApi=" + loadUserApi + ", randomStr=" + randomStr + "]";
	}
	
}
