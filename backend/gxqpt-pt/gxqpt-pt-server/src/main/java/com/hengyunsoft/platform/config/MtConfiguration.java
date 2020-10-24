package com.hengyunsoft.platform.config;

import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.base.id.SnowflakeIDGenerate;
import com.hengyunsoft.commons.handler.GlobalExceptionHandler;
import com.hengyunsoft.platform.commons.feign.DateFormatRegister;

import feign.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hengyunsoft.utils.SpringUtil;
import com.hengyunsoft.validator.extract.DefaultConstraintExtractImpl;
import com.hengyunsoft.validator.extract.IConstraintExtract;

import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.context.ApplicationContext;
@Configuration
public class MtConfiguration {
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
    public DateFormatRegister dateFormatRegister() {
    	
    	return new DateFormatRegister();
    }

    @Bean
    public IdGenerate getIdGenerate(@Value("${id-generator.machine-code:1}") Long machineCode) {
        return new SnowflakeIDGenerate(machineCode);
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        //NONE, 不记录日志 (默认)。
        //BASIC, 只记录请求方法和URL以及响应状态代码和执行时间。
        //HEADERS, 记录请求和应答的头的基本信息。
        //FULL, 记录请求和响应的头信息，正文和元数据。
        return feign.Logger.Level.FULL;
    }

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
