package com.hengyunsoft.security.auth.client.config;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tangyh on 2017/9/15.
 */

public class ServiceAuthConfig {
    @Value("${auth.client.pub-key.path}")
    private String pubKeyPath;
    @Value("${auth.client.id:null}")
    private String clientId;
    @Value("${auth.client.secret}")
    private String clientSecret;
    @Value("${auth.client.token-header}")
    private String tokenHeader;
    @Value("${auth.client.user-id:_user_id}")
    private String userIdHeader;
    @Value("${auth.client.user-name:_user_name}")
    private String userNameHeader;
    /**  */
    @Value("${auth.client.admin-header:_isAdmin}")
    private String adminHeader;
    @Value("${spring.application.name}")
    private String applicationName;

    public String getTokenHeader() {
        return tokenHeader;
    }

    public void setTokenHeader(String tokenHeader) {
        this.tokenHeader = tokenHeader;
    }

    public String getPubKeyPath() {
        return pubKeyPath;
    }

    public void setPubKeyPath(String pubKeyPath) {
        this.pubKeyPath = pubKeyPath;
    }


    public String getClientId() {
        return "null".equals(clientId)?applicationName:clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getToken(HttpServletRequest request){
        return request.getHeader(this.getTokenHeader());
    }

    public String getAdminHeader() {
        return adminHeader;
    }
    public void setAdminHeader(String adminHeader) {
        this.adminHeader = adminHeader;
    }

    public String getUserIdHeader() {
        return userIdHeader;
    }

    public void setUserIdHeader(String userIdHeader) {
        this.userIdHeader = userIdHeader;
    }

    public String getUserNameHeader() {
        return userNameHeader;
    }

    public void setUserNameHeader(String userNameHeader) {
        this.userNameHeader = userNameHeader;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
