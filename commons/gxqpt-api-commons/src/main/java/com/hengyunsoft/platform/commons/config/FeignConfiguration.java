package com.hengyunsoft.platform.commons.config;

import com.hengyunsoft.platform.commons.interceptor.FeignAddHeaderRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Created by ace on 2017/9/12.
 */
@Configuration
public class FeignConfiguration {
    @Bean
    FeignAddHeaderRequestInterceptor getClientTokenInterceptor() {
        return new FeignAddHeaderRequestInterceptor();
    }
}
