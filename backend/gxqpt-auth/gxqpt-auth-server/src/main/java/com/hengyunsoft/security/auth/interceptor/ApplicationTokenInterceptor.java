//package com.hengyunsoft.security.auth.interceptor;
//
//import com.hengyunsoft.security.auth.common.util.jwt.TokenVo;
//import com.hengyunsoft.security.auth.configuration.ClientConfig;
//import com.hengyunsoft.security.auth.service.ApplicationService;
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * 客服端调用拦截器，在调用前，在header中添加微服务的client-token，用于验证
// * @author tangyh
// * @createTime 2017-12-13 18:02
// */
//@Log4j2
//public class ApplicationTokenInterceptor implements RequestInterceptor {
//    @Autowired
//    private ClientConfig clientConfig;
//    @Autowired
//    private ApplicationService applicationService;
//
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        try {
//            TokenVo tokenVo = applicationService.applyToken(clientConfig.getClientId(), clientConfig.getClientSecret());
//            requestTemplate.header(clientConfig.getClientTokenHeader(),
//                    tokenVo.getToken());
//        } catch (Exception e) {
//            log.error("拦截器添加token 头信息失败", e);
//        }
//    }
//}
