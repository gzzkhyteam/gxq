package com.hengyunsoft.platform.controller;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.annotation.UnLogin;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.configuration.GxqptWebappConfig;
import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.api.AuthTokenApi;
import com.hengyunsoft.security.auth.dto.TokenVo;
import com.hengyunsoft.security.auth.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping
public class IndexController {
    @Autowired
    GxqptWebappConfig gxqptWebappConfig;

    @GetMapping
    @UnLogin
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(gxqptWebappConfig.getIndexUrl());
    }

    @Autowired
    AuthTokenApi authTokenApi;
    
    
    @Autowired
    private IUserToken userToken;
    
    @PostMapping("refreshToken")
    @ResponseBody
    @UnLogin
    public String token(HttpServletRequest request) throws Exception {
    	
        Result<TokenVo> result = authTokenApi.token(gxqptWebappConfig.getAppId(), gxqptWebappConfig.getAppSecret());
        if (result.isSuccess() && result.getData() != null) {
        	UserDTO loginUser = LoginInfoUtil.getLoginUser(request);
        	String tokenVal = result.getData().getToken();
			if (loginUser != null) {
            	//若用户已经登录了，那么使用用户token
            	tokenVal  = userToken.encoder(tokenVal, loginUser.getId().toString(),loginUser.getName(),null);
            } 
			return tokenVal;
        }
        return null;
    }
}
