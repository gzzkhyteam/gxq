package com.hengyunsoft.rpc.config;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengyunsoft.rpc.target.repository.redis.UserRedis;

@Configuration
public class UtilConfig {

	@Bean
	public ObjectMapper objectMapper() {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		return mapper;
	}
	
	@Bean
	public UserRedis userRedis() {
		
		return new UserRedis();
	}
}
