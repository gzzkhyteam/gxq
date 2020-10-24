package com.hengyunsoft.platform.loginlog;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.core.api.LoginLogApi;
import com.hengyunsoft.platform.admin.api.core.dto.loginlog.LoginLogDTO;
import com.hengyunsoft.platform.config.GxqptWebappConfig;
import com.hengyunsoft.security.auth.dto.UserDTO;

@Component
public class LoginStatistics implements LoginListener {

	@Autowired
	private LoginLogApi loginLogApi;
	
	private static final String master_login_log_id = "_l_l_i";
	@Autowired 
	private GxqptWebappConfig config;
	@Override
	public void loginSuccess(UserDTO user,HttpServletRequest request) {
		
		LoginLogDTO loginLogDTO = new LoginLogDTO();
		
		loginLogDTO.setAccount(user.getAccount());
		loginLogDTO.setLoginIp(request.getRemoteAddr());
		loginLogDTO.setLoginTime(new Date());
		loginLogDTO.setAppId(config.getAppId());
		loginLogDTO.setAppName(config.getAppName());
		loginLogDTO.setMasterLoginIs(true);
		loginLogDTO.setUserId(user.getId());
		loginLogDTO.setUserName(user.getName());
		
		Result<Long> result = loginLogApi.addLoginLog(loginLogDTO);
		if(result != null && result.isSuccess()) {
			request.getSession().setAttribute(master_login_log_id, result.getData());
		}
	}

	@Override
	public void logoutSuccess(HttpSession session) {

		Long masterLogId = (Long) session.getAttribute(master_login_log_id);
		if(masterLogId == null) {
			return ;
		}
		
		loginLogApi.saveLogoutLog(masterLogId,System.currentTimeMillis());
	}

	public static Long getMasterLoginLogId(HttpSession session) {
		return (Long) session.getAttribute(master_login_log_id);
	}

	public  void writeLoginLog(UserDTO user, Long masterLogId, String appId, String appName) {
		
		LoginLogDTO loginLogDTO = new LoginLogDTO();
		
		loginLogDTO.setAccount(user.getAccount());
		loginLogDTO.setLoginTime(new Date());
		loginLogDTO.setAppId(appId);
		loginLogDTO.setAppName(appName);
		loginLogDTO.setMasterLoginIs(false);
		loginLogDTO.setMasterLoginId(masterLogId);
		loginLogDTO.setUserId(user.getId());
		loginLogDTO.setUserName(user.getName());
		
		loginLogApi.addLoginLog(loginLogDTO);
	}

}
