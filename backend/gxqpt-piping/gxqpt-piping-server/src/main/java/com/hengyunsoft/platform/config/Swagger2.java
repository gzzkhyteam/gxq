package com.hengyunsoft.platform.config;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hengyunsoft.commons.adapter.Swagger2WebMvcConfigurerAdapter;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.servicemodule.annotation.SMSSendModule;
import com.hengyunsoft.commons.servicemodule.annotation.WarnSendModule;
import com.hengyunsoft.commons.servicemodule.annotation.WeiboSendModule;
import com.hengyunsoft.commons.servicemodule.annotation.WeixinSendModule;

import lombok.Data;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2的配置类
 *
 * @author xubin.
 * @create 2017-04-08
 */

@Configuration
@EnableSwagger2
@EnableConfigurationProperties({Swagger2.Swagger2Properties.class})
public class Swagger2 extends Swagger2WebMvcConfigurerAdapter {

    private final static String MODULAR_PIPING = "piping";
    private final static String MODULAR_WARN = "warn";
    private final static String MODULAR_SUPERVISE = "supervise";

    @Override
    protected Swagger2BaseProperties getSwagger2BaseProperties() {
        return swagger2Properties;
    }

    @Autowired
    Swagger2Properties swagger2Properties;

    @Value("${auth.app.token-header}")
    private String tokenHeader;

    @Bean
    public Docket createPipingPubApi() {
        List<Parameter> pars = getParameters();
        ArrayList<ResponseMessage> responseMessages = getResponseMessages();
        String basePackage = swagger2Properties.getPipingMap().get("open-package");
        String basePath = swagger2Properties.getPipingMap().get("base-path");
        return getDocket(swagger2Properties.getPipingMap(),
                basePackage, CommonConstants.SWAGGER_GROUP_PUB + MODULAR_PIPING,
                pars, responseMessages)
                .pathProvider(new RelativePathProvider(servletContext) {
                    @Override
                    public String getApplicationBasePath() {
                        return basePath + super.getApplicationBasePath();
                    }
                });
    }
    
    @Bean
    public Docket createWeixinSendApi() {
    	List<Parameter> pars = getParameters();
    	ArrayList<ResponseMessage> responseMessages = getResponseMessages();
    	String basePath = swagger2Properties.getPipingMap().get("base-path");
    	return getDocket(swagger2Properties.getPipingMap(),
    			WeixinSendModule.class, WeixinSendModule.class.getSimpleName(),
    			pars, responseMessages)
    			.pathProvider(new RelativePathProvider(servletContext) {
    				@Override
    				public String getApplicationBasePath() {
    					return basePath + super.getApplicationBasePath();
    				}
    			});
    }
    
    @Bean
    public Docket createWeiboSendApi() {
    	List<Parameter> pars = getParameters();
    	ArrayList<ResponseMessage> responseMessages = getResponseMessages();
    	String basePath = swagger2Properties.getPipingMap().get("base-path");
    	return getDocket(swagger2Properties.getPipingMap(),
    			WeiboSendModule.class, WeiboSendModule.class.getSimpleName(),
    			pars, responseMessages)
    			.pathProvider(new RelativePathProvider(servletContext) {
    				@Override
    				public String getApplicationBasePath() {
    					return basePath + super.getApplicationBasePath();
    				}
    			});
    }
    
    @Bean
    public Docket createSmsSendApi() {
    	List<Parameter> pars = getParameters();
    	ArrayList<ResponseMessage> responseMessages = getResponseMessages();
    	String basePath = swagger2Properties.getPipingMap().get("base-path");
    	return getDocket(swagger2Properties.getPipingMap(),
    			SMSSendModule.class, SMSSendModule.class.getSimpleName(),
    			pars, responseMessages)
    			.pathProvider(new RelativePathProvider(servletContext) {
    				@Override
    				public String getApplicationBasePath() {
    					return basePath + super.getApplicationBasePath();
    				}
    			});
    }

    @Bean
    public Docket createPipingInsideApi() {
        List<Parameter> pars = getTokenUserParameters();
        ArrayList<ResponseMessage> responseMessages = getResponseMessages();
        String basePackage = swagger2Properties.getPipingMap().get("impl-package");
        String basePath = swagger2Properties.getPipingMap().get("base-path");
        return getDocket(swagger2Properties.getPipingMap(),
                basePackage,
                CommonConstants.SWAGGER_GROUP_INSIDE + MODULAR_PIPING,
                pars, responseMessages)
                .pathProvider(new RelativePathProvider(servletContext) {
                    @Override
                    public String getApplicationBasePath() {
                        return basePath + super.getApplicationBasePath();
                    }
                });
    }

    @Bean
    public Docket createWarnPubApi() {
        List<Parameter> pars = getParameters();
        ArrayList<ResponseMessage> responseMessages = getResponseMessages();
        String basePackage = swagger2Properties.getWarnMap().get("open-package");
        String basePath = swagger2Properties.getWarnMap().get("base-path");
        return getDocket(swagger2Properties.getWarnMap(),
                basePackage, CommonConstants.SWAGGER_GROUP_PUB + MODULAR_WARN,
                pars, responseMessages)
                .pathProvider(new RelativePathProvider(servletContext) {
                    @Override
                    public String getApplicationBasePath() {
                        return basePath + super.getApplicationBasePath();
                    }
                });
    }

    @Bean
    public Docket createWarnInsideApi() {
        List<Parameter> pars = getTokenUserParameters();
        ArrayList<ResponseMessage> responseMessages = getResponseMessages();
        String basePath = swagger2Properties.getWarnMap().get("base-path");
        return getDocket(swagger2Properties.getWarnMap(),
                WarnSendModule.class, CommonConstants.SWAGGER_GROUP_INSIDE + MODULAR_WARN,
                pars, responseMessages)
                .pathProvider(new RelativePathProvider(servletContext) {
                    @Override
                    public String getApplicationBasePath() {
                        return basePath + super.getApplicationBasePath();
                    }
                });
    }

    @Bean
    public Docket createSuperviseInsideApi() {
        List<Parameter> pars = getTokenUserParameters();
        ArrayList<ResponseMessage> responseMessages = getResponseMessages();
        String basePackage = swagger2Properties.getSuperviseMap().get("impl-package");
        String basePath = swagger2Properties.getSuperviseMap().get("base-path");
        return getDocket(swagger2Properties.getSuperviseMap(),
                basePackage, CommonConstants.SWAGGER_GROUP_INSIDE + MODULAR_SUPERVISE,
                pars, responseMessages)
                .pathProvider(new RelativePathProvider(servletContext) {
                    @Override
                    public String getApplicationBasePath() {
                        return basePath + super.getApplicationBasePath();
                    }
                });
    }

    @ConfigurationProperties(
            prefix = "swagger2"
    )
    @Data
    static class Swagger2Properties extends Swagger2BaseProperties {
        private Map<String, String> pipingMap = new LinkedHashMap<>();
        private Map<String, String> warnMap = new LinkedHashMap<>();
        private Map<String, String> superviseMap = new LinkedHashMap<>();
    }
}
