package com.hengyunsoft.security.ratelimit.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 默认当获取用户账号的方法
 *
 * @auth tangyh
 * @date 2018/07/03
 */
public class DefaultUserPrincipal implements IUserPrincipal {
    @Override
    public String getName(HttpServletRequest request) {
        if(request.getUserPrincipal()==null) {
            return null;
        }
        return request.getUserPrincipal().getName();
    }
}
