package com.hengyunsoft.platform.security;

import com.hengyunsoft.security.auth.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInfoUtil {

	public final static String login_user_in_session = "l_u_i_s";
	public static void addLoginUser(UserDTO ssLoginUser, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute(login_user_in_session, ssLoginUser);
	}
	public static UserDTO getLoginUser(HttpServletRequest request) {
		return (UserDTO) request.getSession().getAttribute(login_user_in_session);
		//UserDto  user = new UserDto();
		//user.setId(1L);
		//user.setAccount("admin");
		//return user;
	}

}
