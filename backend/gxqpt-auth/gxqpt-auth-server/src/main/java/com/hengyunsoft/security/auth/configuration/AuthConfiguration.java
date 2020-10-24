package com.hengyunsoft.security.auth.configuration;

import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.base.id.SnowflakeIDGenerate;
import com.hengyunsoft.commons.handler.GlobalExceptionHandler;
import com.hengyunsoft.platform.commons.feign.DateFormatRegister;
import com.hengyunsoft.platform.commons.sec.ISecurityStrategy;
import com.hengyunsoft.platform.commons.sec.impl.DefaultSecurityStrategy;

import com.hengyunsoft.utils.SpringUtil;
import com.hengyunsoft.validator.extract.DefaultConstraintExtractImpl;
import com.hengyunsoft.validator.extract.IConstraintExtract;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * Created by ace on 2017/9/10.
 */
@Configuration
public class AuthConfiguration {

    /**
     * 全局异常处理
     *
     * @return
     */
    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
    @Bean
    public IdGenerate getIdGenerate(@Value("${id-generator.machine-code:1}") Long machineCode) {
        return new SnowflakeIDGenerate(machineCode);
    }

    @Bean
    public ISecurityStrategy securityStrategy() {
        return new DefaultSecurityStrategy();
    }
    
    @Bean
    public DateFormatRegister dateFormatRegister() {
    	
    	return new DateFormatRegister();
    }
}
