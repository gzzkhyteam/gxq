package com.hengyunsoft.platform.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("gxqpt.fast")
@Component
@Data
public class GxqptWebappConfig {

    private String appId;
    private String appSecret;
    /**
     * 首页地址
     */
    private String indexUrl;
    /**
     * 登录url地址
     */
    private String loginUrl;
    /** 业务系统退出地址 */
    private String logoutUrl = "";
}
