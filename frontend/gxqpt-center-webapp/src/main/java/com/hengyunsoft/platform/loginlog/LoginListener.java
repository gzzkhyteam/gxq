package com.hengyunsoft.platform.loginlog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hengyunsoft.security.auth.dto.UserDTO;

public interface LoginListener {

	public void loginSuccess(UserDTO account,HttpServletRequest request);
	public void logoutSuccess(HttpSession session);
}
