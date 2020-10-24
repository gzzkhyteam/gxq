package com.hengyunsoft.security.ratelimit.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取用户账号
 *
 * @auth tangyh
 * @date 2018/07/03
 */
public interface IUserPrincipal {
    String getName(HttpServletRequest request);
}
