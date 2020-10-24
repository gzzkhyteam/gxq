package com.hengyunsoft.platform.security;

import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.cas.sso.ext.CasConfigure;
import com.hengyunsoft.cas.sso.ext.CasFilter;
import com.hengyunsoft.cas.sso.ext.UserLogoutListener;
import com.hengyunsoft.cas.sso.ext.WebUtil;
import com.hengyunsoft.platform.controller.sso.SSOLoginController;
import com.hengyunsoft.platform.loginlog.LoginListener;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.jasig.cas.client.util.URIBuilder;
import org.jasig.cas.client.util.URIBuilder.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.Serializable;
import java.util.List;

public class CasFilterExt extends CasFilter {

	@Autowired
	SSOLoginController ssoLoginController;
	@Autowired
	IdGenerate<? extends Serializable> idIdGenerate;
	@Autowired(required=false)
	private LoginListener loginListener;
	@Autowired
	private LoginCycleCounter loginCycleCounter;
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		
		
		execLoginSuccessNotify(token, (HttpServletRequest)request);
		if(!ssoLoginController.issueSuccessRedirect((HttpServletRequest)request,(HttpServletResponse) response)) {
			return super.onLoginSuccess(token, subject, request, response);
		} else {
			return false;
		}
	}
	
	private void execLoginSuccessNotify(AuthenticationToken token, HttpServletRequest request) {
		
		if(loginListener == null) {
			return ;
		}
		try {
			loginListener.loginSuccess(LoginInfoUtil.loginInfo(), request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void execLogoutSuccessNotify( HttpSession session) {
		
		if(loginListener == null) {
			return ;
		}
		try {
			loginListener.logoutSuccess( session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String constructServiceUrl(HttpServletRequest request, HttpServletResponse response, String serverNames,
			String serviceParameterName, String artifactParameterName, boolean encode, CasConfigure casConfigure) {
		String unique = getClientUnique(request, response);
		//String service = serverNames == null?WebUtil.getFullPath(request) : WebUtil.getBasePath(request) + serverNames;
		String service = null;
		if(serverNames == null || "".equals(serverNames)){
			service = WebUtil.getFullPath(request);
		} else if (serverNames.startsWith("http://") || serverNames.startsWith("https://")){
			service = serverNames;
		} else {
			service = WebUtil.getBasePath(request) + serverNames;
		}
        System.out.println("调整的url" + service);
        final URIBuilder originalRequestUrl = new URIBuilder(service, encode);
        originalRequestUrl.setParameters(request.getQueryString());
        
        URIBuilder newRequestUrl = new URIBuilder(service, encode);
        List<BasicNameValuePair> newParams = newRequestUrl.getQueryParams();
        if(newParams!=null && !newParams.isEmpty()){
            //判断链接中是否存在改链接
            boolean flag = newParams.stream().anyMatch((val)->clientUniqueId_in_Cookies.equals(val.getName()));
            if(!flag){
                newRequestUrl.addParameter(clientUniqueId_in_Cookies, unique);
            }
        }

        List<BasicNameValuePair> pairs = originalRequestUrl.getQueryParams();
        if(pairs != null){
        	
        	for (BasicNameValuePair basicNameValuePair : pairs) {
        		String parName = basicNameValuePair.getName();
        		if(!parName.equals(serviceParameterName) && !parName.equals(artifactParameterName)){
        			newRequestUrl.addParameter(parName, basicNameValuePair.getValue());
        		}
			}
        }
        if(StringUtils.isNotEmpty(casConfigure.getCasServerLogoutNotifyUrl())){
        	String logoutNotifyUrl = casConfigure.getCasServerLogoutNotifyUrl();
        	StringBuilder logoutNotifyUrlPath = new StringBuilder(logoutNotifyUrl);
        	
        	if(logoutNotifyUrl.charAt(logoutNotifyUrl.length()-1) == '/'){
        		logoutNotifyUrlPath.deleteCharAt(logoutNotifyUrlPath.length()-1);
        	}
        	logoutNotifyUrlPath.append(newRequestUrl.getPath());
        	logoutNotifyUrlPath.append("?");
        	logoutNotifyUrlPath.append(clientUniqueId_in_Cookies);
        	logoutNotifyUrlPath.append("=");
        	logoutNotifyUrlPath.append(unique);
        	
        	int loginCycleFlag =  getLoginCycleFlagInSession(request);
        	logoutNotifyUrlPath.append("&");
        	logoutNotifyUrlPath.append(loginCycleFlag_in_service);
        	logoutNotifyUrlPath.append("=");
        	logoutNotifyUrlPath.append(loginCycleFlag);
        	
        	newRequestUrl.addParameter(getLOGOUT_NOTIFY_URL(), logoutNotifyUrlPath.toString());
        }
        
        int loginCycleFlag = getLoginCycleFlagInSession(request);
        
        newRequestUrl.addParameter(loginCycleFlag_in_service, Integer.toString(loginCycleFlag));
        
        return encode ? response.encodeURL(newRequestUrl.toString()) : newRequestUrl.toString();
	}

	public int getLoginCycleFlagInSession(HttpServletRequest request) {
		
		Integer loginCycleFlag = (Integer) request.getSession().getAttribute(loginCycleFlag_in_service);
		if(loginCycleFlag != null) {
			return loginCycleFlag;
		}
		loginCycleFlag = loginCycleCounter.nextCount();
        request.getSession().setAttribute(loginCycleFlag_in_service, loginCycleFlag);
		return loginCycleFlag;
	}

	public String getClientUnique(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String unique = null;
		if(cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if(clientUniqueId_in_Cookies.equals(cookies[i].getName())){
					unique = cookies[i].getValue();
				}
			}
		}
		if(unique == null) {
			unique = idIdGenerate.generate().toString();
			Cookie cookie = new Cookie(clientUniqueId_in_Cookies, unique);
			cookie.setHttpOnly(true);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
		}
		return unique;
	}
	

	public final static String clientUniqueId_in_Cookies = "c_u_id";
	public final static String loginCycleFlag_in_service = "l_g";
	
	
	@Autowired
	@Override
	public void setUserLogoutListener( UserLogoutListener userLogoutListener) {
		super.setUserLogoutListener(new UserLogoutListenerDecorator(this,userLogoutListener));
	}
	
	class  UserLogoutListenerDecorator implements UserLogoutListener {
		private CasFilterExt casFilterExt;
		private UserLogoutListener target;
		
		public UserLogoutListenerDecorator(CasFilterExt casFilterExt, UserLogoutListener target) {
			super();
			this.casFilterExt = casFilterExt;
			this.target = target;
		}

		@Override
		public void logout(HttpServletRequest req, HttpServletResponse res, HttpSession session) {
			casFilterExt.execLogoutSuccessNotify(session);
			this.target.logout(req, res, session);
		}
	}
}
