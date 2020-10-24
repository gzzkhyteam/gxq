package com.hengyunsoft.platform;

import com.hengyunsoft.platform.admin.api.authority.api.RoleApi;
import com.hengyunsoft.platform.admin.api.authority.api.UserApi;
import com.hengyunsoft.platform.admin.api.core.api.GxqptDpmApi;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.api.GxqptOrgApi;
import com.hengyunsoft.platform.admin.api.core.api.LoginLogApi;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.piping.open.SmsSendApi;
import com.hengyunsoft.platform.piping.open.WarnMessageSendOpenApi;
import com.hengyunsoft.security.auth.api.AuthTokenApi;
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
@ComponentScan(
        basePackages = {"com.hengyunsoft.platform",
                "com.hengyunsoft.commons.utils.context"}
//  ,excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.hengyunsoft.platform.*.api.[a-zA-Z]+.api.hystrix[.a-zA-Z]+")
//}
)
@EnableFeignClients(clients = {LoginLogApi.class, ApplicationApi.class, AuthTokenApi.class, UserApi.class,
        SmsSendApi.class, WarnMessageSendOpenApi.class, GxqptOrgApi.class, GxqptDpmApi.class, GxqptEmpApi.class, RoleApi.class})
@EnableTransactionManagement
@EnableGxqptAuthClient
@EnableScheduling
public class GxqptPipingServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GxqptPipingServerApplication.class, args);
    }
}
