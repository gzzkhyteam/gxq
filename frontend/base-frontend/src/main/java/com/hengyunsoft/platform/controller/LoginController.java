package com.hengyunsoft.platform.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;
import com.hengyunsoft.platform.configuration.GxqptWebappConfig;
import com.hengyunsoft.platform.interceptor.LoginCheckInterceptor;
import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.api.AuthTokenApi;
import com.hengyunsoft.security.auth.api.UserApi;
import com.hengyunsoft.security.auth.dto.UserDTO;
import com.hengyunsoft.sso.demo.config.SSOConfig;
import com.hengyunsoft.sso.demo.controller.SSOServlet;
import com.hengyunsoft.sso.demo.servlet.SessionStorage;
import com.hengyunsoft.sso.demo.vo.SSOLoginUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("login")
public class LoginController extends SSOServlet {

    private final static int EXPIRE_SECONDS = 2 * 24 * 3600;
    @Autowired
    private UserApi userApi;
    @Autowired
    private AuthTokenApi authTokenApi;
    @Autowired
    private GxqptWebappConfig gxqptWebappConfig;
    @Autowired
    private IUserToken userToken;

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
        //查用户身份
        Result<UserDTO> result = userApi.getById(loginUser.getUserid());
        UserDTO loginUserInfo = result.getData();
        LoginInfoUtil.addLoginUser(loginUserInfo, request, response);
        LoginInfoUtil.addSSOLoginUser(loginUser, request, response);

        setTokenCookie(loginUser.getToken(), request, response);

        setCpCookie(request, response);

        //以前想要完全去掉用户id放入前端，让前端使用，避免安全问题
        //但是太多的地方已经使用了在cookie中获取用户id，所以只能够放开，后继接口不允许使用cookie中的userId
        setUserIdCookie(loginUserInfo.getId(), request, response);

        sendRedirect(request, response);
    }

    public void sendRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setLoginUrlCookie(gxqptWebappConfig.getLoginUrl(), request, response);
        String redirectUrl = LoginCheckInterceptor.removeRequestContentInSession(request);
        if (StringUtils.isEmpty(redirectUrl)) {
            redirectUrl = gxqptWebappConfig.getIndexUrl();
        }
        response.sendRedirect(redirectUrl);
    }

    public String setUserTokenToCookie(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        UserDTO loginUserInfo = LoginInfoUtil.getLoginUser(request);

        SSOLoginUser ssoLoginUser = LoginInfoUtil.getSSOLoginUser(request);

        List<Object> userTokenInfo = userToken.uncoder(ssoLoginUser.getToken());

        String token = getAppToken();

        UserTokenExtInfo extInfo = userToken.getUserTokenExtInfo(userTokenInfo);

        token = userToken.encoder(token, loginUserInfo.getId().toString(), loginUserInfo.getName(), extInfo);

        setTokenCookie(URLEncoder.encode(token, "utf-8"), request, response);
        return token;
    }

    private void setUserIdCookie(Long usreId, HttpServletRequest request, HttpServletResponse response) {
        Cookie userIdCookie = new Cookie("_user_id", usreId.toString());
        userIdCookie.setPath(request.getContextPath());
        userIdCookie.setSecure(false);
        response.addCookie(userIdCookie);
    }

    @Override
    public String getAppToken() {
        //return TokenCache.of(gxqptWebappConfig.getAppId(), gxqptWebappConfig.getAppSecret()).get().get();
        return authTokenApi.token(gxqptWebappConfig.getAppId(), gxqptWebappConfig.getAppSecret()).getData().getToken();
    }


    private void setCpCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cpCookie = new Cookie("_cp", request.getContextPath());
        cpCookie.setPath(request.getContextPath());
        cpCookie.setSecure(false);
        response.addCookie(cpCookie);
    }

    private void setTokenCookie(String token, HttpServletRequest request, HttpServletResponse response) {
        Cookie tokenCookie = new Cookie("_token", token);
        tokenCookie.setPath(request.getContextPath());
        tokenCookie.setSecure(false);
        response.addCookie(tokenCookie);
    }

    private void setLoginUrlCookie(String loginUrl, HttpServletRequest request, HttpServletResponse response) {


        Cookie tokenCookie = new Cookie("_loginUrl", loginUrl);
        tokenCookie.setPath(request.getContextPath());
        tokenCookie.setSecure(false);
        response.addCookie(tokenCookie);
    }


}
