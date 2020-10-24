package com.hengyunsoft.platform.logs.dto;

import com.hengyunsoft.platform.logs.entity.logs.domain.LogTypeDO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luchanghong
 * @create 2018-08-31 16:06
 * @desc 日志类型统计
 **/
public class LogTypeMap {
    private List<LogTypeDO> apache;
    private List<LogTypeDO> app;
    private List<LogTypeDO> nginx;
    private List<LogTypeDO> tomcat;

    public LogTypeMap() {
        this.apache = new ArrayList<LogTypeDO>();
        this.app = new ArrayList<LogTypeDO>();
        this.nginx = new ArrayList<LogTypeDO>();
        this.tomcat = new ArrayList<LogTypeDO>();
    }

    public List<LogTypeDO> getApache() {
        return apache;
    }

    public void setApache(List<LogTypeDO> apache) {
        this.apache = apache;
    }

    public List<LogTypeDO> getApp() {
        return app;
    }

    public void setApp(List<LogTypeDO> app) {
        this.app = app;
    }

    public List<LogTypeDO> getNginx() {
        return nginx;
    }

    public void setNginx(List<LogTypeDO> nginx) {
        this.nginx = nginx;
    }

    public List<LogTypeDO> getTomcat() {
        return tomcat;
    }

    public void setTomcat(List<LogTypeDO> tomcat) {
        this.tomcat = tomcat;
    }
}