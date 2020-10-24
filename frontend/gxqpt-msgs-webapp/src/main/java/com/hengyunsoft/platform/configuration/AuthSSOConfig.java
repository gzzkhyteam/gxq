package com.hengyunsoft.platform.configuration;


import com.hengyunsoft.sso.demo.config.SSOConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("sso")
@Component
public class AuthSSOConfig extends SSOConfig {

}
