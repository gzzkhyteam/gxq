package com.hengyunsoft.platform;

import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.base.id.SnowflakeIDGenerate;
import com.hengyunsoft.platform.admin.api.core.api.LoginLogApi;
import com.hengyunsoft.security.auth.api.ApplicationApi;
import com.hengyunsoft.security.auth.api.AuthTokenApi;
import com.hengyunsoft.security.auth.api.RoleApi;
import com.hengyunsoft.security.auth.api.UserApi;
import com.hengyunsoft.security.auth.client.EnableGxqptAuthClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import util.IShareCache;
import util.LocalShareCache;


/**
 * 启动器
 * <p>
 * Hystrix:服务容错保护
 * front端 调用 service端 服务时，当service端服务出现异常时， 避免front端服务长时间等待。
 * 该框架的目标在于通过控制那些访问远程系统、服务和第三方库的节点，从而对延迟和故障提供更强大的容错能力。
 * Hystrix具备服务降级、服务熔断、线程和信号隔离、请求缓存、请求合并以及服务监控等强大功能。
 *
 * @author tyh
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients= {LoginLogApi.class,UserApi.class,AuthTokenApi.class,RoleApi.class,ApplicationApi.class})
@ComponentScan(basePackages = {"com.hengyunsoft.platform"})
@ComponentScan(
        //    basePackages = {
        //    "com.hengyunsoft.platform.admin.api.account.api",
        //    "com.hengyunsoft.platform.admin.repository.authority.service",
        //    "com.hengyunsoft.base.id",
        //}
    includeFilters = {
        //@ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.hengyunsoft.platform.admin.api.[a-zA-Z]+.api.hystrix[.a-zA-Z]+"),
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.hengyunsoft.platform.*.api.[a-zA-Z]+.api.hystrix[.a-zA-Z]+"),
    }
)
@EnableHystrix
@Configuration
@EnableGxqptAuthClient
public class GxqptCenterWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(GxqptCenterWebApplication.class, args);
    }

    @Bean
    public IShareCache shareCache() {

        return new LocalShareCache();
    }

    @Bean
    public IdGenerate<Long> idGenerate() {

        return new SnowflakeIDGenerate(0);
    }
}
