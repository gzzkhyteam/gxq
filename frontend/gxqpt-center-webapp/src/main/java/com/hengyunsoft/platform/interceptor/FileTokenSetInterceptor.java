//package com.hengyunsoft.platform.interceptor;
//
//import org.springframework.beans.factory.annotation.Value;
//
//public class FileTokenSetInterceptor extends TokenSetInterceptor {
//    @Value("${gxqpt.app-id.file}")
//    private String appId;
//    @Value("${gxqpt.app-secret.file}")
//    private String appSecret;
//
//    @Override
//    protected String getCurAppId() {
//        return appId;
//    }
//
//    @Override
//    protected String getAppSecret() {
//        return appSecret;
//    }
//}
