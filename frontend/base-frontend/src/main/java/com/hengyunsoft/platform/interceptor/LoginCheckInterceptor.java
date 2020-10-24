package com.hengyunsoft.platform.interceptor;

import com.hengyunsoft.platform.configuration.GxqptWebappConfig;
import com.hengyunsoft.platform.security.LoginInfoUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录检查连接器
 * 
 * @author Administrator
 *
 */
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private GxqptWebappConfig gxqptWebappConfig;
	private String ajaxUnloginResponseBody = null;
	private static Logger log = LoggerFactory.getLogger(LoginCheckInterceptor.class);
	/**
	 * 
	 * 记录在跳转登录前想要访问的目标地址   仅仅支持GET方式的请求，POST方式不记录
	 * 因为post方式上下文信息不好还原，而get方式可以通过重定向来复原。
	 */
	public final static String LOGIN_BEFORE_TARGTE_URL = "L_B_TARGTE_U";
	
	public void saveRequestContentToSession(HttpServletRequest request) {
		if(!"GET".equals(request.getMethod())) {
			//只有get请求才恢复上下文信息。post请求因为有些参数在流里面不好处理。故只考虑get
			return ;
		}
		// 修复bug(7977)停留在当前界面很久不操作》再次点击页面功能》退出到登录界面》重新登录后系统缺少logo栏目（其他系统也有这个问题）
		//保存get请求，且请求必须导向首页。  比如： http://127.0.0.1:10086/gxqpt-authority/module/index?url=/gxqpt-authority/power/systemList
		StringBuilder url = null;
		if(!request.getRequestURI().contains(gxqptWebappConfig.getIndexUrl())) {
	    	//将如下请求： http://127.0.0.1:10086/gxqpt-authority/power/systemList?params=qwerwer
	    	//改写成：     /gxqpt-authority/module/index?url=/gxqpt-authority/power/systemList?params=qwerwer进行存储
	    	url = new StringBuilder(gxqptWebappConfig.getIndexUrl());
	    	url.append("?");
	    	url.append("url=");
	    	url.append(request.getRequestURI());
	    	String params = request.getQueryString();
	    	if(params != null) {
	    		url.append("?");
	    		url.append(params);
	    	}
	    } else {
	    	//比如： http://127.0.0.1:10086/gxqpt-authority/module/index
	    	url = new StringBuilder(request.getRequestURL().toString());
	    	String params = request.getQueryString();
	    	if(params != null) {
	    		url.append("?");
	    		url.append(params);
	    	}
	    }
	    request.getSession().setAttribute(LOGIN_BEFORE_TARGTE_URL, url.toString());
	}
	
	public static String removeRequestContentInSession(HttpServletRequest request) {
		
		String url = (String) request.getSession().getAttribute(LOGIN_BEFORE_TARGTE_URL);
		if(url != null) {
			request.getSession().removeAttribute(LOGIN_BEFORE_TARGTE_URL);
		}
		return url;
	}
	
	private void toLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//根据请求类型不同（ajax    普通http  ）进行具体处理
		boolean isAjax = isAjaxRequest(request);
		if(isAjax) {
			response.setContentType("application/json");
			response.getWriter().write(ajaxUnloginResponseBody);
		} else {
			
			saveRequestContentToSession(request);
			
			log.error(request.getContextPath() + gxqptWebappConfig.toString());
			response.sendRedirect(gxqptWebappConfig.getLoginUrl());
		}
	}
	
	public String getAjaxUnloginResponseBody() {
		
		if(ajaxUnloginResponseBody == null) {
			init();
		}
		return ajaxUnloginResponseBody;
	}


	private synchronized void init() {
		
		ajaxUnloginResponseBody = "{\"errcode\":50005,\"errmsg\":用户未登录,\"data\":\""+gxqptWebappConfig.getLoginUrl()+"\"}";
	}


	public void setAjaxUnloginResponseBody(String ajaxUnloginResponseBody) {
		this.ajaxUnloginResponseBody = ajaxUnloginResponseBody;
	}


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//判断是否登录
		boolean notLogin = LoginInfoUtil.getLoginUser(request) == null ;
		if (notLogin && mustLogin(request,response,handler)) {
			//未登录   去登录
			toLogin(request,response);
			
			return false;
		} 
		return true;
	}


	


	
	protected boolean mustLogin(HttpServletRequest request, HttpServletResponse response, Object handler) {
		
		return true;
	}

	public static boolean isAjaxRequest(HttpServletRequest request) {
		// 判断是否ajax请求
		if (request.getHeader("x-requested-with") != null
				&& request.getHeader("x-requested-with").equalsIgnoreCase(
						"XMLHttpRequest")) {
			return true;
		}
		return false;
	}

	public GxqptWebappConfig getGxqptWebappConfig() {
		return gxqptWebappConfig;
	}
}
