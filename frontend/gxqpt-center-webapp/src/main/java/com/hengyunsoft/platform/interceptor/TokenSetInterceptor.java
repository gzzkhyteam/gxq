package com.hengyunsoft.platform.interceptor;

import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.cache.TokenCache;
import com.hengyunsoft.security.auth.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Optional;


@Slf4j
public class TokenSetInterceptor extends HandlerInterceptorAdapter {
//    /**
//     * token超时时间
//     */
//    private final static int EXPIRE_SECONDS = 24 * 3600;
//    @Value("${gxqpt.center.app-id}")
//    private String appId;
//    @Value("${gxqpt.center.app-secret}")
//    private String appSecret;
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) {
//        try {
//            UserDTO accountDTO = LoginInfoUtil.loginInfo();
//            if (accountDTO != null) {
//                Optional<String> optional =
//                        TokenCache.of(appId, appSecret ).get();
//                if (optional.isPresent()) {
//                    String tokenVal = optional.get();
//                    request.setAttribute("_token", tokenVal);
//                    request.setAttribute("_user_id", accountDTO.getId());
//                    request.setAttribute("_user_name", accountDTO.getName());
//                    request.setAttribute("_user_photo", accountDTO.getPhoto());
//
//                    tokenVal = tokenVal.replace("+", "%20");
//                    Cookie tokenCookie = new Cookie("_token", tokenVal);
//                    tokenCookie.setPath("/");
//                    tokenCookie.setSecure(false);
//                    tokenCookie.setMaxAge(EXPIRE_SECONDS);
//                    response.addCookie(tokenCookie);
//
//                    Cookie userCookie = new Cookie("_user_id", String.valueOf(accountDTO.getId()));
//                    userCookie.setPath("/");
//                    userCookie.setSecure(false);
//                    userCookie.setMaxAge(EXPIRE_SECONDS);
//                    response.addCookie(userCookie);
//
//                    String userName = "";
//                    if(!Strings.isNullOrEmpty(accountDTO.getName())){
//                        userName = URLEncoder.encode(accountDTO.getName(), "UTF-8");
//                    }
//                    Cookie userNameCookie = new Cookie("_user_name", userName);
//                    userNameCookie.setPath("/");
//                    userNameCookie.setSecure(false);
//                    userNameCookie.setMaxAge(EXPIRE_SECONDS);
//                    response.addCookie(userNameCookie);
//                }
//            }
//        } catch (Exception e) {
//            log.error("token 拦截发送异常", e);
//        }
//        //Enumeration<String> attributeNames = request.getAttributeNames();
//        //while (attributeNames.hasMoreElements()) {
//        //    String val = attributeNames.nextElement();
//        //    System.out.println("val=" + val + "----" + request.getAttribute(val));
//        //}
//
//        //System.out.println("---------------" + request.getAttribute("_token"));
//    }



}
