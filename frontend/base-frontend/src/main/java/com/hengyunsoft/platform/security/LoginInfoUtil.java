package com.hengyunsoft.platform.security;

import com.hengyunsoft.security.auth.dto.UserDTO;
import com.hengyunsoft.sso.demo.vo.SSOLoginUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInfoUtil {

	public final static String login_user_in_session = "l_u_i_s";
	public final static String sso_login_user_in_session = "s_l_u_i_s";
	public static void addLoginUser(UserDTO ssLoginUser, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute(login_user_in_session, ssLoginUser);
	}

	
	public static UserDTO getLoginUser(HttpServletRequest request) {
		return (UserDTO) request.getSession().getAttribute(login_user_in_session);

	}


	public static void addSSOLoginUser(SSOLoginUser loginUser, HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().setAttribute(sso_login_user_in_session,loginUser);
	}
	
	public static SSOLoginUser getSSOLoginUser(HttpServletRequest request) {
		return (SSOLoginUser) request.getSession().getAttribute(sso_login_user_in_session);
	}
}
