//package com.hengyunsoft.security.auth.configuration;
//
//import com.hengyunsoft.utils.SpringUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 初始化open server 容器
// *
// * @author tyh
// * @createTime 2017-12-25 16:31
// */
//@Configuration
//@Slf4j
//public class AuthInitializer implements ApplicationContextAware {
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println("authinitialer =================");
//        log.info("authinitialer =================");
//        SpringUtil.setApplicationContext(applicationContext);
//
//        System.out.println("-authinitialer--" + applicationContext == null);
//        log.info("-authinitialer--{}", applicationContext == null);
//    }
//}
