package com.hengyunsoft.security.gete.auth;

/**
 * 用户权限认证
 * 判断用户是否具有访问某个应用的指定资源的权限。
 * 这个认证仅仅使用在内部应用的访问   内网关
 *
 * @author Administrator
 */
public interface UserAuth {

    /**
     * 是否允许访问请求
     *
     * @param appId  前端应用id
     * @param userId 判断谁的权限
     * @param token  因为在加载资源的时候，需要token   暂时还没有想到有什么好的方案解决token的问题
     * @return true 标示允许           否则拒绝
     */
    boolean isPass(String appId, Long userId, String url, String token);
}
