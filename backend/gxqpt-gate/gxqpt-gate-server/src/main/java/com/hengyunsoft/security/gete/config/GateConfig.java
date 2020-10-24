package com.hengyunsoft.security.gete.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.commons.sec.impl.BitEncryptUserToken;
import com.hengyunsoft.security.logoutflag.ILogoutFlagStorage;
import com.hengyunsoft.security.logoutflag.impl.LogoutFlagManager;

@Configuration
public class GateConfig {

	
    @Bean
    IUserToken userToken() {
    	
    	return new BitEncryptUserToken(new ObjectMapper());
    }
    
    @Bean
    ILogoutFlagStorage logoutFlagStorage() {
    	
    	return new LogoutFlagManager();
    }
}
