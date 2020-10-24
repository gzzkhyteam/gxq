package com.hengyunsoft.platform;

import com.hengyunsoft.security.auth.client.EnableGxqptAuthClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author tyh
 * @createTime 2017-11-19 21:00
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableTransactionManagement
@EnableFeignClients({
        "com.hengyunsoft.platform",
})
@ComponentScan(
        basePackages = {"com.hengyunsoft.platform",
                "com.hengyunsoft.commons.utils.context",
                "com.hengyunsoft.platform.search.api"})
//        excludeFilters = {
////                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.hengyunsoft.platform.*.api.[a-zA-Z]+.api.hystrix[.a-zA-Z]+"),
////                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.hengyunsoft.platform.*.open.[a-zA-Z]+.api.hystrix[.a-zA-Z]+"),
//        })
@EnableGxqptAuthClient
@Configuration
public class GxqptExchangeServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GxqptExchangeServerApplication.class, args);
    }
}
