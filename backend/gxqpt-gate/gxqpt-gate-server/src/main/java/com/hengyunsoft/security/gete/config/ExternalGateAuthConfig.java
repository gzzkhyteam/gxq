package com.hengyunsoft.security.gete.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hengyunsoft.security.gete.auth.ApplicationAuth;
import com.hengyunsoft.security.gete.auth.impl.DefaultApplicationAuthImpl;
import com.hengyunsoft.utils.SpringUtil;

/**
 * 外网关权限配置
 * @author Administrator
 *
 */
@Configuration
public class ExternalGateAuthConfig {

	@Bean
	public ApplicationAuth applicationAuth() {
		return new DefaultApplicationAuthImpl();
	}


	@Bean
	public SpringUtil springUtil(ApplicationContext applicationContext) {

		SpringUtil.setApplicationContext(applicationContext);
		return new SpringUtil();
	}
}
