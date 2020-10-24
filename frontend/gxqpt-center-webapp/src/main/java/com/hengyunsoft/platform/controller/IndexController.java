package com.hengyunsoft.platform.controller;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;
import com.hengyunsoft.platform.config.GxqptWebappConfig;
import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.api.AuthTokenApi;
import com.hengyunsoft.security.auth.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tyh
 * @createTime 2017-11-20 17:05
 */
@Controller
@RequestMapping("")
@Slf4j
public class IndexController {
    @Autowired
    GxqptWebappConfig gxqptWebappConfig;

    @RequestMapping("")
    public String main(ModelMap model) {
        return "admin/index";
    }

    @RequestMapping("index")
    public String index(ModelMap model) {
        return "index";
    }

    @RequestMapping("search")
    public String searchResultList(ModelMap model) {
        return "search_result_list";
    }

    //    @Value("${gxqpt.center.app-id}")
//    private String appId;
//    @Value("${gxqpt.center.app-secret}")
//    private String appSecret;
//    @Autowired
//    AuthTokenApi authTokenApi;
    @Autowired
    private IUserToken userToken;
    @Autowired
    private AuthTokenApi authTokenApi;
//    @PostMapping("refreshToken")
//    @ResponseBody
//    public String token() {
//        Result<TokenVo> result = authTokenApi.token(appId, appSecret);
//        if (result.isSuccess() && result.getData() != null) {
//            return result.getData().getToken();
//        }
//        return null;
//    }


    @PostMapping("refreshToken")
    @ResponseBody
    public String token(HttpServletRequest request, HttpServletResponse response) throws Exception {


        String token = authTokenApi.token(gxqptWebappConfig.getAppId(), gxqptWebappConfig.getAppSecret()).getData().getToken();
        
        UserDTO loginUserInfo = LoginInfoUtil.getLoginUser(request);
        UserTokenExtInfo userTokenInfo = new UserTokenExtInfo();
    	userTokenInfo.setAccount(loginUserInfo.getAccount());
    	userTokenInfo.setRoles(LoginInfoUtil.getLoginUserAdminAppIds());
        token = userToken.encoder(token, loginUserInfo.getId().toString(), loginUserInfo.getName(), userTokenInfo);
        setTokenCookie(URLEncoder.encode(token, "utf-8"), request, response);
        return token;
    }

    private void setTokenCookie(String token, HttpServletRequest request, HttpServletResponse response) {
        Cookie tokenCookie = new Cookie("_token", token);
        tokenCookie.setPath(request.getContextPath());
        tokenCookie.setSecure(false);
        response.addCookie(tokenCookie);
    }
}
