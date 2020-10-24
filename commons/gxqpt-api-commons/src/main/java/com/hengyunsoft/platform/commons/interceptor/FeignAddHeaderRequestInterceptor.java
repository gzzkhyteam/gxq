package com.hengyunsoft.platform.commons.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class FeignAddHeaderRequestInterceptor implements RequestInterceptor {

    public FeignAddHeaderRequestInterceptor() {
        super();
    }

    @Override
    public void apply(RequestTemplate template) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        String token = (String) requestAttributes.getAttribute("token", RequestAttributes.SCOPE_SESSION);
        if (token == null || "".equals(token.trim())) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            if (request == null) {
                return;
            }
            token = ((ServletRequestAttributes) requestAttributes).getRequest().getHeader("token");
        }

        String userId = (String) requestAttributes.getAttribute("_user_id", RequestAttributes.SCOPE_SESSION);
        if (userId == null || "".equals(userId.trim())) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            if (request == null) {
                return;
            }
            userId = ((ServletRequestAttributes) requestAttributes).getRequest().getHeader("_user_id");
        }

        String userName = (String) requestAttributes.getAttribute("_user_name", RequestAttributes.SCOPE_SESSION);
        if (userName == null || "".equals(userName.trim())) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            if (request == null) {
                return;
            }
            userName = ((ServletRequestAttributes) requestAttributes).getRequest().getHeader("_user_name");
        }

        System.out.println("-feign-add-interceptor-userId=" + userId + ",username=" + userName);
        template.header("token", token);
        template.header("_user_id", userId);
        template.header("_user_name", userName);
    }
}
