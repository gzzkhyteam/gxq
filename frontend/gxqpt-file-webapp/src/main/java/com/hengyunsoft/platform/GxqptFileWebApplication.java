package com.hengyunsoft.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients({
        //"com.hengyunsoft.platform.admin.api.base.api",
        //"com.hengyunsoft.platform.admin.api.core.api",
        //"com.hengyunsoft.platform.admin.api.authority.api",
        //"com.hengyunsoft.platform.file.api",
        "com.hengyunsoft.security.auth.api",
})
@ComponentScan(basePackages = {"com.hengyunsoft.platform"})
@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.hengyunsoft.platform.*.api.[a-zA-Z]+.api.hystrix[.a-zA-Z]+"),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.hengyunsoft.platform.*.api.hystrix[.a-zA-Z]+"),
        }
)
@EnableHystrix
@Configuration
public class GxqptFileWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(GxqptFileWebApplication.class, args);
    }
}
