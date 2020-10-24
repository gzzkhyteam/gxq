package com.hengyunsoft.platform.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.commons.sec.impl.BitEncryptUserToken;
import com.hengyunsoft.platform.interceptor.LoginCheckInterceptor;
import com.hengyunsoft.platform.interceptor.ReferrerInterceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration("centerWebConfig")
@Primary
public class WebConfiguration extends WebMvcConfigurerAdapter {
	@Value("${gxqpt.variable.gate-url:}") 
	private String gatewayUrl;
	
    @Bean
    ReferrerInterceptor referrerInterceptor() {
    	ReferrerInterceptor referrerInterceptor = new ReferrerInterceptor();
    	List<String> applicationWhiteList = Arrays.asList(gatewayUrl);
		referrerInterceptor.setApplicationWhiteList(applicationWhiteList );
    	return referrerInterceptor;
    }
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(referrerInterceptor()).addPathPatterns("/**");
        ArrayList<String> commonPathPatterns = getExcludeCommonPathPatterns();
        registry.addInterceptor(getLoginCheckInterceptor()).addPathPatterns("/**").excludePathPatterns(commonPathPatterns.toArray(new String[]{}));
        super.addInterceptors(registry);
    }


    private ArrayList<String> getExcludeCommonPathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/error",
                "/v2/api-docs",
                "/swagger-resources/**",
                "/client/**",
                "/login/**",
                "/jwt/**"
        };
        Collections.addAll(list, urls);
        return list;
    }

    @Bean
    LoginCheckInterceptor getLoginCheckInterceptor() {
        return new LoginCheckInterceptor();
    }

    @Bean
    IUserToken userToken(ObjectMapper obj) {
    	
    	return new BitEncryptUserToken(obj);
    }
}
