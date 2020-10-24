package com.hengyunsoft.security.auth.common.util.jwt;

/**
 * Created by ace on 2017/9/10.
 */
public interface IJWTInfo {

    /**
     * 获取用户ID
     *
     * @return
     */
    //Long getUserId();

    /**
     * 获取用户昵称
     *
     * @return
     */
    //String getName();

    /**
     * 应用id
     */
    String getAppId();
    String getAppName();
}
