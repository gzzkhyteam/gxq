package com.hengyunsoft.platform.logs.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LogType {
    APACHE("APACHE"),
    TOMCAT("TOMCAT"),
    APP("应用系统"),
    NGINX("NGINX"),
    ;

    private String logdescript;
}
