package com.hengyunsoft.platform.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengyunsoft.cas.sso.ext.CasConfigure;
import com.hengyunsoft.cas.sso.ext.MultipleCasConfigureManager;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.commons.sec.impl.BitEncryptUserToken;
import com.hengyunsoft.platform.interceptor.ReferrerInterceptor;
import com.hengyunsoft.platform.interceptor.TokenSetInterceptor;
import com.hengyunsoft.platform.security.LoginCycleCounter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Configuration("centerWebConfig")
@Primary
public class CenterWebConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private MultipleCasConfigureManager casConfigureManager;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getTokenSetInterceptor()).addPathPatterns("/admin/**");
        registry.addInterceptor(getReferrerInterceptor()).addPathPatterns("/**").excludePathPatterns("/slogin","/svalidate","/admin/index");

        super.addInterceptors(registry);
    }

    @Bean
    public ReferrerInterceptor getReferrerInterceptor() {
    	
    	List<String> applicationWhiteList = new ArrayList<>();
    	Map<String, CasConfigure> sso = casConfigureManager.getCasConfigures();
    	if(sso!=null) {
    		for (CasConfigure cas : sso.values()) {
    			applicationWhiteList.add(cas.getCasServerLoginUrl().substring(0, cas.getCasServerLoginUrl().indexOf('/', 10)));
			}
    		if(casConfigureManager.getDefaultCasConfigure() != null) {
    			CasConfigure config = casConfigureManager.getDefaultCasConfigure();
    			applicationWhiteList.add(config.getCasServerLoginUrl().substring(0, config.getCasServerLoginUrl().indexOf('/', 10)));
    		}
    	}
    	ReferrerInterceptor referrerInterceptor = new ReferrerInterceptor();
    	referrerInterceptor.setApplicationWhiteList(applicationWhiteList);
		return referrerInterceptor;
	}

	private ArrayList<String> getExcludeCommonPathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/v2/api-docs",
                "/swagger-resources/**",
                "/client/**",
                "/jwt/**"
        };
        Collections.addAll(list, urls);
        return list;
    }

    @Bean
     TokenSetInterceptor getTokenSetInterceptor() {
        return new TokenSetInterceptor();
    }

    @Bean
    IUserToken userToken(ObjectMapper obj) {
    	
    	return new BitEncryptUserToken(obj);
    }
    
    @Bean
    LoginCycleCounter LoginCycleCounter() {
    	
    	return new LoginCycleCounter();
    }
    
}
