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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




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
    IUserToken userToken(ObjectMapper obj) {
    	
    	return new BitEncryptUserToken(obj);
    }
    @Bean
    LoginCheckInterceptor getLoginCheckInterceptor() {
    	return new LoginCheckInterceptor(){
    		@Override
    		protected boolean mustLogin(HttpServletRequest request, HttpServletResponse response, Object handler) {
    			if("0".equals(request.getParameter("needLogin"))) {
    				request.setAttribute("mt_visit", "0");
    			}
    			return super.mustLogin(request, response, handler);
    		}
    		@Override
    		public void saveRequestContentToSession(HttpServletRequest request) {
    			
    			if(request.getAttribute("mt_visit") != null) {
    				StringBuilder url = new StringBuilder(request.getRequestURL().toString());
    				url.append("?");
    				url.append(request.getQueryString());
    				request.getSession().setAttribute(LOGIN_BEFORE_TARGTE_URL, url.toString());
    			} else {
    				super.saveRequestContentToSession(request);
    			}
    		}
    	};
    }
}
