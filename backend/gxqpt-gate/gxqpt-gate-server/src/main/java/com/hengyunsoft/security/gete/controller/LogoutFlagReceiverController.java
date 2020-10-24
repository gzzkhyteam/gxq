package com.hengyunsoft.security.gete.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.security.logoutflag.ILogoutFlagStorage;

/**
 * 
 * 用户退出单点登录后，需要向网关报告退出标记
 * @author 潘定遥
 *
 */
@RestController
@RequestMapping("logoutflag")
public class LogoutFlagReceiverController {

	@Autowired
	private ILogoutFlagStorage logoutFlagStorage ;
	
	@RequestMapping("")
	public String receiver(HttpServletRequest req) {
		Integer logoutFlag = Integer.valueOf(req.getParameter("logoutFlag"));
		if(logoutFlag == null) {
			return "SUCCESS";
		}
		logoutFlagStorage.addLogoutFlag(logoutFlag);
		return "SUCCESS";
	}
}

