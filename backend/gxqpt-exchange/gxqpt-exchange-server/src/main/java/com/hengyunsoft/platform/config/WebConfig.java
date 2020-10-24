package com.hengyunsoft.platform.config;

import com.hengyunsoft.security.auth.client.interceptor.AppAuthRestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.Collections;


/**
 * @author tyh
 * @createTime 2017-12-15 17:35
 */
@Configuration("webConfig")
@Primary
@Order(Integer.MIN_VALUE)
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> commonPathPatterns = getExcludeCommonPathPatterns();
        registry.addInterceptor(getAuthRestInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(commonPathPatterns.toArray(new String[]{}));
        super.addInterceptors(registry);
    }

    @Bean
    AppAuthRestInterceptor getAuthRestInterceptor() {
        return new AppAuthRestInterceptor();
    }

    private ArrayList<String> getExcludeCommonPathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/error",
                "/v2/api-docs",
                "/swagger-resources/**",
                "/cache/**",
                "/swagger-ui.html**",
        };
        Collections.addAll(list, urls);
        return list;
    }
}
