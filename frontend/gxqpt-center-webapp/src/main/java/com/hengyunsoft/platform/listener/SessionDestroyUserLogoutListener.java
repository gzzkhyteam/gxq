package com.hengyunsoft.platform.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


import com.hengyunsoft.platform.loginlog.LoginStatistics;

/**
 * session销毁时，默认用户退出了，应对用户非正常退出的问题。
 * @author 潘定遥
 *
 */
public class SessionDestroyUserLogoutListener implements HttpSessionListener {

	private LoginStatistics loginStatistics;
	
	public SessionDestroyUserLogoutListener(LoginStatistics loginStatistics) {
		super();
		this.loginStatistics = loginStatistics;
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

		if(loginStatistics == null) {
			return ;
		}
		HttpSession session = se.getSession();
		loginStatistics.logoutSuccess(session);
	}

	public void setLoginStatistics(LoginStatistics loginStatistics) {
		this.loginStatistics = loginStatistics;
	}
}
