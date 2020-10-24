package com.hengyunsoft.security.auth.client.configuration;

import com.hengyunsoft.security.auth.client.config.ServiceAuthConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.commons.sec.impl.BitEncryptUserToken;
import com.hengyunsoft.security.auth.client.config.AppAuthConfig;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author tyh
 * @createTime 2017-12-13 15:27
 */
@Configuration
@ComponentScan({"com.hengyunsoft.security.auth.client", "com.hengyunsoft.security.auth.common.event"})
@RemoteApplicationEventScan(basePackages = "com.hengyunsoft.security.auth.common.event")
public class AutoConfiguration {
    @Bean
    ServiceAuthConfig getServiceAuthConfig() {
        return new ServiceAuthConfig();
    }

    @Bean
    AppAuthConfig getUserAuthConfig() {
        return new AppAuthConfig();
    }
    
    @Bean
    IUserToken userToken(ObjectMapper objectMapper) {
    	
    	return new BitEncryptUserToken(objectMapper);
    }
}