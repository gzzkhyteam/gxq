package com.hengyunsoft.platform.interceptor;

import com.hengyunsoft.platform.annotation.MustLogin;
import com.hengyunsoft.platform.annotation.UnLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
public class LoginCheckInterceptorExt extends LoginCheckInterceptor {

	@Override
	protected boolean mustLogin(HttpServletRequest request, HttpServletResponse response, Object handler){
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		MustLogin mustLogin = handlerMethod.getMethod().getAnnotation(MustLogin.class);
		if(mustLogin != null) {
			return true;
		}
		
		UnLogin unLogin = handlerMethod.getMethod().getAnnotation(UnLogin.class);
		if(unLogin != null) {
			return false;
		}
		 mustLogin = handlerMethod.getBeanType().getAnnotation(MustLogin.class);
		if(mustLogin != null) {
			return true;
		}
		
		 unLogin = handlerMethod.getBeanType().getAnnotation(UnLogin.class);
		if(unLogin != null) {
			return false;
		}
		
		return true;
	}


}
