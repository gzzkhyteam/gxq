package com.hengyunsoft.platform.standard;

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

/**
 * 消息服务 
 *
 * @author tyh
 * @createTime 2018-01-25 10:13
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableHystrix
@EnableScheduling
@ComponentScan({
        "com.hengyunsoft.platform",
        "com.hengyunsoft.commons.utils.context",
})
//@ComponentScan(
//        includeFilters = {
//                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.hengyunsoft.platform.*.api.[a-zA-Z]+.api.hystrix[.a-zA-Z]+"),
//        }
//)
@EnableFeignClients(value = {
        "com.hengyunsoft.platform.file.open",
        "com.hengyunsoft.platform.file.api",
        "com.hengyunsoft.security.auth.api",
        "com.hengyunsoft.platform.admin.open.core.api",
        "com.hengyunsoft.platform.admin.open.authority.api",
        "com.hengyunsoft.platform.supervise",
})
@EnableTransactionManagement
@EnableGxqptAuthClient
public class GxqptStandardServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GxqptStandardServerApplication.class, args);
    }



}
