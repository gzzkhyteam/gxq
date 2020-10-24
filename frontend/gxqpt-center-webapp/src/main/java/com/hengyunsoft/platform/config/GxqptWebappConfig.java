package com.hengyunsoft.platform.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("gxqpt.center")
@Configuration
@Data
public class GxqptWebappConfig {


//    private String authStr;
    private String appId;
    private String appSecret;
    private String appName;
    /**
     * token有效期
     */
//    private Integer token_expire_min;

}
