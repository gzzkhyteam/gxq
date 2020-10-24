package com.hengyunsoft.security.auth.common.util.jwt;


import java.io.Serializable;
import java.util.Objects;

/**
 * Created by ace on 2017/9/10.
 */
public class JWTInfo implements Serializable, IJWTInfo {
    private String appName;
    private String appId;

    public JWTInfo(String appId, String appName) {
        this.appId = appId;
        this.appName = appName;
    }

    @Override
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JWTInfo jwtInfo = (JWTInfo) o;
        return Objects.equals(appId, jwtInfo.appId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appId);
    }
}
