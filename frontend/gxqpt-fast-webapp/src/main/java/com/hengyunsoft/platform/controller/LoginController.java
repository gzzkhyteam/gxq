package com.hengyunsoft.platform.controller;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.configuration.GxqptWebappConfig;
import com.hengyunsoft.platform.interceptor.LoginCheckInterceptor;
import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.api.UserApi;
import com.hengyunsoft.security.auth.cache.TokenCache;
import com.hengyunsoft.security.auth.dto.UserDTO;
import com.hengyunsoft.sso.demo.config.SSOConfig;
import com.hengyunsoft.sso.demo.controller.SSOServlet;
import com.hengyunsoft.sso.demo.servlet.SessionStorage;
import com.hengyunsoft.sso.demo.vo.SSOLoginUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;

@Controller()
@Slf4j
@RequestMapping("/login")
public class LoginController extends SSOServlet {

    @Autowired
    private UserApi userApi;
    @Autowired
    private GxqptWebappConfig gxqptWebappConfig;
    
    @Autowired
    private IUserToken userToken ;

    public LoginController() {

    }

    @PostConstruct
    private void doInit() {

        setSessionStorage(new SessionStorage());
    }

    @Override
    @Autowired
    public void setSsoConfig(SSOConfig ssoConfig) {
        super.setSsoConfig(ssoConfig);
    }

    @RequestMapping("")
    @Override
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {


        super.login(request, response);
    }

    @RequestMapping("logout")
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response)
            throws IOException, URISyntaxException {
        super.logout(request, response);
    }

    @RequestMapping("validate")
    @Override
    public void validate(HttpServletRequest request, HttpServletResponse response)
            throws IOException, URISyntaxException, ServletException {
        // TODO Auto-generated method stub
        super.validate(request, response);
    }

    @Override
    protected void doLogout(HttpSession session) {

    	try {
			session.invalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    protected String getReqType(HttpServletRequest arg0, HttpServletResponse arg1) {

        return null;
    }

    @Override
    protected void loginSuccess(SSOLoginUser loginUser, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        log.info("uesrlogined={}, userid", loginUser.getLogined(), loginUser.getUserid());
        //查用户身份
        Result<UserDTO> result = userApi.getById(loginUser.getUserid());
        UserDTO loginUserInfo = result.getData();
        LoginInfoUtil.addLoginUser(loginUserInfo, request, response);


        setCpCookie(request, response);
        
        try {
			setUserTokenToCookie(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizException(-1, "用户级token生成失败，联系管理员");
		}
        
        setUserIdCookie(loginUserInfo.getId(),request, response);
        setUserNameCookie(loginUserInfo.getName(), request,response);
        setLoginUrlCookie(gxqptWebappConfig.getLoginUrl(),request, response);
        String redirectAfterUrl = (String) request.getSession().getAttribute(LoginCheckInterceptor.Redirect_After_Url);
        if(StringUtils.isEmpty(redirectAfterUrl)) {
            response.sendRedirect(gxqptWebappConfig.getIndexUrl());
        } else {
            response.sendRedirect(redirectAfterUrl);
            request.getSession().removeAttribute(LoginCheckInterceptor.Redirect_After_Url);
        }
    }

    private void setCpCookie(HttpServletRequest request,  HttpServletResponse response) {
        Cookie cpCookie = new Cookie("_cp",  request.getContextPath());
        cpCookie.setPath("/");
        cpCookie.setSecure(false);
        response.addCookie(cpCookie);
    }
    
	public  String setUserTokenToCookie(HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		
		UserDTO loginUserInfo = LoginInfoUtil.getLoginUser(request);
		String token = getAppToken();
		
        token = userToken.encoder(token, loginUserInfo.getId().toString(),loginUserInfo.getName(),null);
        
        setTokenCookie(URLEncoder.encode(token,"utf-8"),request, response);
        return token;
	}
    
    private void setTokenCookie(String token,HttpServletRequest request, HttpServletResponse response) {
        Cookie tokenCookie = new Cookie("_token", token);
        tokenCookie.setPath(request.getContextPath());
        tokenCookie.setSecure(false);
        response.addCookie(tokenCookie);
    }

    private void setUserIdCookie(Long userId,HttpServletRequest request, HttpServletResponse response) {
        Cookie userCookie = new Cookie("_user_id", String.valueOf(userId));
        userCookie.setPath(request.getContextPath());
        userCookie.setSecure(false);
        response.addCookie(userCookie);
    }

    private void setUserNameCookie(String userName,HttpServletRequest request, HttpServletResponse response) {
        try {
            if (!Strings.isNullOrEmpty(userName)) {
                Cookie userNameCookie = new Cookie("_user_name", URLEncoder.encode(userName, "UTF-8"));
                userNameCookie.setPath(request.getContextPath());
                userNameCookie.setSecure(false);
                response.addCookie(userNameCookie);
            }
        } catch (Exception e) {
            log.error("写入username cookie报错", e);
        }
    }

    private void setLoginUrlCookie(String loginUrl,HttpServletRequest request, HttpServletResponse response) {
        Cookie tokenCookie = new Cookie("_loginUrl", loginUrl);
        tokenCookie.setPath(request.getContextPath());
        tokenCookie.setSecure(false);
        response.addCookie(tokenCookie);
    }
    
	@Override
	public String getAppToken() {
		return TokenCache.of(gxqptWebappConfig.getAppId(), gxqptWebappConfig.getAppSecret()).get().get();
	}
}
