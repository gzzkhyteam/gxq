package com.hengyunsoft.security.gete.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hengyunsoft.security.gete.auth.UserAuth;
import com.hengyunsoft.security.gete.auth.impl.AppResourceManager;
import com.hengyunsoft.security.gete.auth.impl.DefaultUserAuthImpl;
import com.hengyunsoft.security.gete.auth.impl.RedisCache;
import com.hengyunsoft.security.gete.auth.impl.UserResourceManager;
import com.hengyunsoft.security.gete.utils.IShareCache;

/**
 * 内网关配置鉴权
 * @author Administrator
 *
 */
@Configuration
public class InsideGateAuthConfig {
	@Bean
	IShareCache shareCache() {
		
		return new RedisCache();
	}
	
	@Bean
	AppResourceManager appResourceManager() {
		
		return new AppResourceManager();
	}
	@Bean
	UserAuth userAuth() {
		
		return new DefaultUserAuthImpl();
	}
	@Bean
	UserResourceManager userResourceManager() {
		
		return new UserResourceManager();
	}
}
