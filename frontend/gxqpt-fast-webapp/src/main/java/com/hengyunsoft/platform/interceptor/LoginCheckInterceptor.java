package com.hengyunsoft.platform.interceptor;

import com.hengyunsoft.platform.configuration.GxqptWebappConfig;
import com.hengyunsoft.platform.security.LoginInfoUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录检查连接器
 *
 * @author Administrator
 */
@Slf4j
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private GxqptWebappConfig gxqptWebappConfig;
    private String ajaxUnloginResponseBody = null;
    /**
     * 重定向到登录界面前的用户想要做的url被记录下来，登录成功后可以继续处理
     */
    public static final String Redirect_After_Url = "r_a_u_l";

    public String getAjaxUnloginResponseBody() {

        if (ajaxUnloginResponseBody == null) {
            init();
        }
        return ajaxUnloginResponseBody;
    }


    private synchronized void init() {
        ajaxUnloginResponseBody = "{\"errcode\":50005,\"errmsg\":用户未登录,\"data\":\"" + gxqptWebappConfig.getLoginUrl() + "\"}";
    }


    public void setAjaxUnloginResponseBody(String ajaxUnloginResponseBody) {
        this.ajaxUnloginResponseBody = ajaxUnloginResponseBody;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否登录
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        //boolean isNeedLogin = isNeedLogin(handlerMethod);
        //if(!isNeedLogin) {
        //    return true;
        //}
        boolean notLogin = LoginInfoUtil.getLoginUser(request) == null;
        if (notLogin) {
            //未登录   去登录
            toLogin(request, response);

            return false;
        }
        return true;
    }
    //private boolean isNeedLogin(HandlerMethod handlerMethod) {
    //    MustLogin mustLogin = handlerMethod.getMethod().getAnnotation(MustLogin.class);
    //    if(mustLogin != null) {
    //        return true;
    //    }
    //
    //    UnLogin unLogin = handlerMethod.getMethod().getAnnotation(UnLogin.class);
    //    if(unLogin != null) {
    //        return false;
    //    }
    //    mustLogin = handlerMethod.getBeanType().getAnnotation(MustLogin.class);
    //    if(mustLogin != null) {
    //        return true;
    //    }
    //
    //    unLogin = handlerMethod.getBeanType().getAnnotation(UnLogin.class);
    //    if(unLogin != null) {
    //        return false;
    //    }
    //
    //    return true;
    //}

    private void toLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //根据请求类型不同（ajax    普通http  ）进行具体处理
        boolean isAjax = isAjaxRequest(request);
        if (isAjax) {
            response.setContentType("application/json");
            response.getWriter().write(ajaxUnloginResponseBody);
        } else {
            String url = request.getRequestURI();
            if (StringUtils.isNotEmpty(request.getQueryString())) {
                url += "?" + request.getQueryString();
            }
            request.getSession().setAttribute(Redirect_After_Url, url);
            response.sendRedirect(gxqptWebappConfig.getLoginUrl());
        }
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

}
