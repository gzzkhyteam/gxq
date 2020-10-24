package com.hengyunsoft.platform;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hengyunsoft.platform.admin.api.authority.api.RoleApi;
import com.hengyunsoft.platform.admin.api.authority.api.UserApi;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.security.auth.client.EnableGxqptAuthClient;

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
@ComponentScan({
        "com.hengyunsoft.platform",
		"com.hengyunsoft.platform.commons",
        "com.hengyunsoft.commons.utils.context",
})
@EnableScheduling
@EnableTransactionManagement
@EnableGxqptAuthClient
@EnableFeignClients(
		clients = {RoleApi.class,ApplicationApi.class,UserApi.class,GxqptEmpApi.class}
)
public class GxqptMsgsApplication {
	
	@Autowired
	private ApplicationApi applicationApi;
	
	@PostConstruct
	public void init() {

		System.out.println(applicationApi);
	}
	
    public static void main(String[] args) {
        SpringApplication.run(GxqptMsgsApplication.class, args);
    }
    
    
}
