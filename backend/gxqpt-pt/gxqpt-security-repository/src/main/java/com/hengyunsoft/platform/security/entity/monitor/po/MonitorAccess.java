package com.hengyunsoft.platform.security.entity.monitor.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class MonitorAccess extends BaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 来访服务器ip地址
     *
     * @mbggenerated
     */
    private String fromServerIp;

    /**
     * 服务器账号
     *
     * @mbggenerated
     */
    private String account;

    /**
     * 登录时间
     *
     * @mbggenerated
     */
    private Date loginTime;

    /**
     * 登出时间
     *
     * @mbggenerated
     */
    private Date logoutTime;

    /**
     * 登录时长
     *
     * @mbggenerated
     */
    private String loginDuration;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 目标服务器Ip地址
     *
     * @mbggenerated
     */
    private String toServerIp;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 来访服务器ip地址
     *
     * @mbggenerated
     */
    public String getFromServerIp() {
        return fromServerIp;
    }

    /**
     * 来访服务器ip地址
     *
     * @mbggenerated
     */
    public void setFromServerIp(String fromServerIp) {
        this.fromServerIp = fromServerIp == null ? null : fromServerIp.trim();
    }

    /**
     * 服务器账号
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * 服务器账号
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 登录时间
     *
     * @mbggenerated
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 登录时间
     *
     * @mbggenerated
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 登出时间
     *
     * @mbggenerated
     */
    public Date getLogoutTime() {
        return logoutTime;
    }

    /**
     * 登出时间
     *
     * @mbggenerated
     */
    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    /**
     * 登录时长
     *
     * @mbggenerated
     */
    public String getLoginDuration() {
        return loginDuration;
    }

    /**
     * 登录时长
     *
     * @mbggenerated
     */
    public void setLoginDuration(String loginDuration) {
        this.loginDuration = loginDuration;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 目标服务器Ip地址
     *
     * @mbggenerated
     */
    public String getToServerIp() {
        return toServerIp;
    }

    /**
     * 目标服务器Ip地址
     *
     * @mbggenerated
     */
    public void setToServerIp(String toServerIp) {
        this.toServerIp = toServerIp == null ? null : toServerIp.trim();
    }
}