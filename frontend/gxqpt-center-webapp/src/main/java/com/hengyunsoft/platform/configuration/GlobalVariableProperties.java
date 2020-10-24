package com.hengyunsoft.platform.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static com.hengyunsoft.platform.configuration.GlobalVariableProperties.GLOBAL_VARIABLE_PREFIX;

@ConfigurationProperties(prefix = GLOBAL_VARIABLE_PREFIX)
@Data
@NoArgsConstructor
@Configuration
public class GlobalVariableProperties {
    public static final String GLOBAL_VARIABLE_PREFIX = "gxqpt.variable";

    /** 网关访问地址 */
    private String gateUrl = "";
    /** 单点登录退出地址 */
    private String logoutUrl = "";
}
