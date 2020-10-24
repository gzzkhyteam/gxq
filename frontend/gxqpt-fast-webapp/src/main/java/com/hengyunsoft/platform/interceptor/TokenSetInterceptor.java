package com.hengyunsoft.platform.interceptor;

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
import java.util.Optional;


@Slf4j
public class TokenSetInterceptor extends HandlerInterceptorAdapter {
    /**
     * token超时时间
     */
    private final static int EXPIRE_SECONDS = 24 * 3600;
    @Autowired
    private GxqptWebappConfig gxqptWebappConfig;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
//        try {
//            UserDTO loginUser = LoginInfoUtil.getLoginUser(request);
//            if (loginUser != null) {
//                Optional<String> optional =
//                        TokenCache.of(gxqptWebappConfig.getAppId(), gxqptWebappConfig.getAppSecret()).get();
//                if (optional.isPresent()) {
//                    String tokenVal = optional.get();
//                    request.setAttribute("_token", tokenVal);
//                    request.setAttribute("_user_id", loginUser.getId());
//                    request.setAttribute("_user_name", loginUser.getName());
//                    request.setAttribute("_user_photo", loginUser.getPhoto());
//
//                    tokenVal = tokenVal.replace("+", "%20");
//                    Cookie tokenCookie = new Cookie("_token", tokenVal);
//                    tokenCookie.setPath(request.getServletContext().getContextPath());
//                    tokenCookie.setSecure(false);
//                    tokenCookie.setMaxAge(EXPIRE_SECONDS);
//                    response.addCookie(tokenCookie);
//
//                }
//            }
//        } catch (Exception e) {
//            log.error("token 拦截发送异常", e);
//        }
    }


}
