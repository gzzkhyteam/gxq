package com.hengyunsoft.platform.interceptor;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ReferrerInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 应用白名单： 格式为： http://ip:port/projectname  以前缀匹配
	 */
	private List<String> applicationWhiteList = Collections.EMPTY_LIST;
	private final static String REFERER = "referer";
	private  static String currentProjectRoot ;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String referer = request.getHeader(REFERER);
		if(referer == null) {
			return true;
		}
		if(currentProjectRoot == null) {
			initValue(request);
		}
		if(referer.startsWith(currentProjectRoot)) {
			return true;
		}
		if(!applicationWhiteList.isEmpty()) {
			for (String applicationWhite : applicationWhiteList) {
				if(referer.startsWith(applicationWhite)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private synchronized void initValue(HttpServletRequest request) {
		if(currentProjectRoot != null) {
			return ;
		}
		String path = request.getContextPath();
	    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		currentProjectRoot = basepath; 

	}

	public List<String> getApplicationWhiteList() {
		return applicationWhiteList;
	}

	public void setApplicationWhiteList(List<String> applicationWhiteList) {
		this.applicationWhiteList = applicationWhiteList;
	}

}
