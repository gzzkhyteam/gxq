package com.hengyunsoft.platform.security;

import com.hengyunsoft.security.auth.dto.UserDTO;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class LoginInfoUtil {

	public static UserDTO loginInfo() {
		if(SecurityUtils.getSubject() == null) {
			return null;
		}
		return (UserDTO) SecurityUtils.getSubject().getPrincipal();
	}
	
	public final static String login_user_in_session = "l_u_i_s";
	public final static String login_user_admin_app_in_session = "l_u_a_p_i_s";

	public static void addLoginUser(UserDTO ssLoginUser, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute(login_user_in_session, ssLoginUser);
	}
	
	public static UserDTO getLoginUser(HttpServletRequest request) {
		return (UserDTO) request.getSession().getAttribute(login_user_in_session);
	}

	public static void addLoginUser(UserDTO data) {
		
		addLoginUser(data, getRequest(), null);
	}
	
	public static HttpServletRequest getRequest() {
	       HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	       return request;
	}

	public static void addLoginUserAdminAppIds(Long adminAppIds) {
		HttpSession session = getRequest().getSession();
		if(adminAppIds == null) {
			adminAppIds = 0L ;
		}
		session.setAttribute(login_user_admin_app_in_session, adminAppIds);
	}

	public static Long getLoginUserAdminAppIds() {
		return (Long) getRequest().getSession().getAttribute(login_user_admin_app_in_session);
	}
}
