package com.hengyunsoft.platform.interceptor;

import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.configuration.GxqptWebappConfig;
import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.cache.TokenCache;
import com.hengyunsoft.security.auth.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Optional;

/**
 * 不再使用拦截请求      设置cookie
 * @author Administrator
 *
 */
@Slf4j
public class TokenSetInterceptor extends HandlerInterceptorAdapter {
    /**
     * token超时时间
     */
    @Autowired
    private GxqptWebappConfig gxqptDeveloperWebappConfig;
    @Autowired
    private IUserToken userToken;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
        try {
            Cookie[] cookies = request.getCookies();
            if (notExist(cookies,"_token")) {
            	Optional<String> optional =
                    TokenCache.of(gxqptDeveloperWebappConfig.getAppId(), gxqptDeveloperWebappConfig.getAppSecret()).get();
            	    UserDTO loginUser = LoginInfoUtil.getLoginUser(request);
            		//默认是应用级token
            		String tokenVal = optional.get();
            		
	            	if (loginUser != null) {
	                	//若用户已经登录了，那么使用用户token
	                	tokenVal = userToken.encoder(tokenVal, loginUser.getId().toString(),loginUser.getName(),null);
		            }
	            	tokenVal = URLEncoder.encode(tokenVal,Charset.defaultCharset().name());
	            	
                    Cookie tokenCookie = new Cookie("_token", tokenVal);
                    tokenCookie.setPath(request.getContextPath());
                    response.addCookie(tokenCookie);
            }
        } catch (Exception e) {
            log.error("token 拦截发送异常", e);
        }
    }

	private boolean notExist(Cookie[] cookies, String cookieKey) {
		
		if(cookies == null) {
			return true;
		}
		for (Cookie cookie : cookies) {
			if(cookieKey.equals(cookie.getName())) {
				return false;
			};
		}
		return true;
	}
}
