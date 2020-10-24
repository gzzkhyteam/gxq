package com.hengyunsoft.platform.modular.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NexusConfig {

    @Value("${nexus.serverUrl}")
    private String serverUrl;

    @Value("${nexus.logDir}")
    private String logDir;

    @Value("${nexus.username}")
    private String username;

    @Value("${nexus.password}")
    private String password;

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getLogDir() {
        return logDir;
    }

    public void setLogDir(String logDir) {
        this.logDir = logDir;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
