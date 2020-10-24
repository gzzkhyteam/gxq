package com.hengyunsoft.platform;

import com.hengyunsoft.security.auth.client.EnableGxqptAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableHystrix
@ComponentScan({
        "com.hengyunsoft.platform",
//        "com.hengyunsoft.platform.commons",
        "com.hengyunsoft.commons.utils.context",
})
@EnableFeignClients({
        "com.hengyunsoft.platform",
        "com.hengyunsoft.security.auth.api",
})
@EnableScheduling
@EnableTransactionManagement
@EnableGxqptAuthClient
public class GxqptPtApplication {
    public static void main(String[] args) {
        SpringApplication.run(GxqptPtApplication.class, args);
    }
}
