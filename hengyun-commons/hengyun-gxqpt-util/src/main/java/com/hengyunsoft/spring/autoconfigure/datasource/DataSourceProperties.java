package com.hengyunsoft.spring.autoconfigure.datasource;


/**
 * 自定义MySQL数据源属性
 * Created by tyh on 2017年11月18日 01:01:24
 * @author tyh
 */
public class DataSourceProperties {
    private String url;
    private String username;
    private String password;
    private Integer maxActive = 4;
    private String driverClassName = "com.mysql.jdbc.Driver";

    /**
     * MySQL连接串
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * MySQL用户名
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * MySQL密码
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }
}