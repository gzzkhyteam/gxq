package com.hengyunsoft.platform.security.entity.monitor.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class MonitorServer extends BaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 服务ip
     *
     * @mbggenerated
     */
    private String serverIp;

    /**
     * 服务名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 账号
     *
     * @mbggenerated
     */
    private String account;

    /**
     * 预警时间
     *
     * @mbggenerated
     */
    private Date warnTime;

    /**
     * 状态 0 未处理 1已处理
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 处理人
     *
     * @mbggenerated
     */
    private String handleUser;

    /**
     * 处理时间
     *
     * @mbggenerated
     */
    private Date handleTime;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remarks;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 服务ip
     *
     * @mbggenerated
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * 服务ip
     *
     * @mbggenerated
     */
    public void setServerIp(String serverIp) {
        this.serverIp = serverIp == null ? null : serverIp.trim();
    }

    /**
     * 服务名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 服务名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 账号
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * 账号
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 预警时间
     *
     * @mbggenerated
     */
    public Date getWarnTime() {
        return warnTime;
    }

    /**
     * 预警时间
     *
     * @mbggenerated
     */
    public void setWarnTime(Date warnTime) {
        this.warnTime = warnTime;
    }

    /**
     * 状态 0 未处理 1已处理
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 0 未处理 1已处理
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 处理人
     *
     * @mbggenerated
     */
    public String getHandleUser() {
        return handleUser;
    }

    /**
     * 处理人
     *
     * @mbggenerated
     */
    public void setHandleUser(String handleUser) {
        this.handleUser = handleUser == null ? null : handleUser.trim();
    }

    /**
     * 处理时间
     *
     * @mbggenerated
     */
    public Date getHandleTime() {
        return handleTime;
    }

    /**
     * 处理时间
     *
     * @mbggenerated
     */
    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}