package com.hengyunsoft.platform.config;

import java.util.Date;
import java.util.List;

import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.base.id.SnowflakeIDGenerate;
import com.hengyunsoft.commons.handler.GlobalExceptionHandler;
import com.hengyunsoft.platform.commons.feign.DateFormatRegister;
import com.hengyunsoft.platform.commons.utils.String2DateConverter;
import com.hengyunsoft.security.auth.client.interceptor.AppAuthRestInterceptor;
import com.hengyunsoft.utils.SpringUtil;
import com.hengyunsoft.validator.extract.DefaultConstraintExtractImpl;
import com.hengyunsoft.validator.extract.IConstraintExtract;

import javax.annotation.PostConstruct;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * @author tyh
 * @createTime 2017-12-15 14:42
 */
@Configuration
public class AdminConfiguration {
	
    @Bean
    public DateFormatRegister dateFormatRegister() {
    	
    	return new DateFormatRegister();
    }
	
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

   /* *//*************************验证架构方面的配置start
     * @throws Exception ******************************//*
    @Bean
    public IConstraintExtract constraintExtract() throws Exception {
    	
    	return new DefaultConstraintExtractImpl(validator());
    }
    
    @Bean
    public Validator validator() {
    	
		return Validation.buildDefaultValidatorFactory().getValidator();
	}
    *//*************************验证架构方面的配置end******************************//*
    
    @Bean
    public SpringUtil springUtil(ApplicationContext applicationContext) {
    	
    	SpringUtil.setApplicationContext(applicationContext);
    	return new SpringUtil();
    }*/
    ////////////////////////////////验证架构方面的配置start//////////////////////////////////
    //	   依赖的jar包是：
    //     <dependency>
    //        	<groupId>com.hengyunsoft</groupId>
    //			<artifactId>validator</artifactId>
    //			<version>0.0.1-SNAPSHOT</version>
    //        </dependency>
    //
    //    前端获取验证规则，需要如下实现
    //    @RestController
    //    public class ValidatorController extends FromValidatorStandard{
    //
    //    }
    /////////////////////////////////////////////////////////////////////////////////////////
    @Bean
    public IConstraintExtract constraintExtract() throws Exception {

        return new DefaultConstraintExtractImpl(validator());
    }

    @Bean
    public Validator validator() {

        return Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Bean
    public SpringUtil springUtil(ApplicationContext applicationContext) {

        SpringUtil.setApplicationContext(applicationContext);
        return new SpringUtil();
    }
    ////////////////////////////////验证架构方面的配置end/////////////////////////////////////

}
