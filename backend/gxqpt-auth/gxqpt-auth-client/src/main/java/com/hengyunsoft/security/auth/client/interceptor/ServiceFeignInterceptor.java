package com.hengyunsoft.security.auth.client.interceptor;

import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.security.auth.client.config.AppAuthConfig;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tangyh
 * @date 2017/9/15
 */
public class ServiceFeignInterceptor implements RequestInterceptor {
    //@Autowired
    //private ServiceAuthConfig serviceAuthConfig;
    @Autowired
    private AppAuthConfig userAuthConfig;
    //@Autowired
    //private ServiceAuthUtil serviceAuthUtil;

    public ServiceFeignInterceptor() {
    }


    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(userAuthConfig.getTokenHeader(), BaseContextHandler.getToken());
    }

    //public void setServiceAuthConfig(ServiceAuthConfig serviceAuthConfig) {
    //    this.serviceAuthConfig = serviceAuthConfig;
    //}

    public void setUserAuthConfig(AppAuthConfig userAuthConfig) {
        this.userAuthConfig = userAuthConfig;
    }

    //public void setServiceAuthUtil(ServiceAuthUtil serviceAuthUtil) {
    //    this.serviceAuthUtil = serviceAuthUtil;
    //}
}