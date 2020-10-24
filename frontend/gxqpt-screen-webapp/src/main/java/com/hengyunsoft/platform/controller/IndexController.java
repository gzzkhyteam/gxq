package com.hengyunsoft.platform.controller;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.annotation.UnLogin;
import com.hengyunsoft.platform.configuration.GxqptWebappConfig;
import com.hengyunsoft.security.auth.api.AuthTokenApi;
import com.hengyunsoft.security.auth.dto.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
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

    @Value("${gxqpt.variable.gate-url}${server.context-path:}")
    String contextPath;

    @RequestMapping
    public void main(HttpServletResponse response) throws IOException {
        response.sendRedirect(contextPath + "/module/index");
    }

    @RequestMapping("index")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect(contextPath + "/module/index");
    }

    @Autowired
    AuthTokenApi authTokenApi;
    @PostMapping("refreshToken")
    @ResponseBody
    @UnLogin
    public String token() {
        Result<TokenVo> result = authTokenApi.token(gxqptWebappConfig.getAppId(), gxqptWebappConfig.getAppSecret());
        if (result.isSuccess() && result.getData() != null) {
            return result.getData().getToken();
        }
        return null;
    }
}
