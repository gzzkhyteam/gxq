package com.hengyunsoft.platform.sms.entity.template.dos;

import java.util.List;

public class AppointDeleteAppDO {
	private String account;
	private List<String> apps;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public List<String> getApps() {
		return apps;
	}
	public void setApps(List<String> apps) {
		this.apps = apps;
	}
}
