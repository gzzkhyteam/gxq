package com.hengyunsoft.security.auth;

import com.hengyunsoft.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author tyh
 * @createTime 2017-12-13 17:45
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients({"com.hengyunsoft.platform.admin.api.account.api"})
@ComponentScan(basePackages = {"com.hengyunsoft.security.auth"})
@ComponentScan(basePackages = {
        "com.hengyunsoft.platform.admin.repository.base.service",
        "com.hengyunsoft.platform.admin.repository.core.service",
        "com.hengyunsoft.platform.developer.repository.apply.service",
        "com.hengyunsoft.commons.utils.context",
        "com.hengyunsoft.platform.admin.repository.authority.service",
        "com.hengyunsoft.platform.developer.repository.service.service",
})

@EnableFeignClients(value = {
        "com.hengyunsoft.security.auth.api"
})
@EnableScheduling
@RemoteApplicationEventScan(basePackages = "com.hengyunsoft.security.auth.common.event")
@Slf4j
public class GxqptAuthApplication implements ApplicationContextAware {
    public static void main(String[] args) {
        SpringApplication.run(GxqptAuthApplication.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("authinitialer =================");
        log.info("authinitialer =================");
        SpringUtil.setApplicationContext(applicationContext);

        System.out.println("-authinitialer--" + applicationContext == null);
        log.info("-authinitialer--{}", applicationContext == null);
    }
}
