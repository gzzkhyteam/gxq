package com.hengyunsoft.platform;

import com.hengyunsoft.security.auth.client.EnableGxqptAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableHystrix
@ComponentScan({
        "com.hengyunsoft.platform",
        "com.hengyunsoft.commons.utils.context",
})
@EnableFeignClients({
        "com.hengyunsoft.platform.developer.api.core.api",
})
@EnableTransactionManagement
@EnableGxqptAuthClient
public class GxqptSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(GxqptSearchApplication.class, args);
    }
}
