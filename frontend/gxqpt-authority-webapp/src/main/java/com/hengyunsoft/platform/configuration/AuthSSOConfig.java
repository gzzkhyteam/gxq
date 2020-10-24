package com.hengyunsoft.platform.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.hengyunsoft.sso.demo.config.SSOConfig;

@ConfigurationProperties("sso")
@Component
public class AuthSSOConfig extends SSOConfig {

}
