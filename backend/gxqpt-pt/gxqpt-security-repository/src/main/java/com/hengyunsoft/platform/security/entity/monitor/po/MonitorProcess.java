package com.hengyunsoft.platform.security.entity.monitor.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class MonitorProcess extends BaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 服务器ip
     *
     * @mbggenerated
     */
    private String serverIp;

    /**
     * 进程id
     *
     * @mbggenerated
     */
    private String processId;

    /**
     * 进程名称
     *
     * @mbggenerated
     */
    private String processName;

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
     * 处理状态 0未处理 1已处理
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

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 修改人
     *
     * @mbggenerated
     */
    private Long updateUser;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 服务器ip
     *
     * @mbggenerated
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * 服务器ip
     *
     * @mbggenerated
     */
    public void setServerIp(String serverIp) {
        this.serverIp = serverIp == null ? null : serverIp.trim();
    }

    /**
     * 进程id
     *
     * @mbggenerated
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * 进程id
     *
     * @mbggenerated
     */
    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    /**
     * 进程名称
     *
     * @mbggenerated
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * 进程名称
     *
     * @mbggenerated
     */
    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
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
     * 处理状态 0未处理 1已处理
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 处理状态 0未处理 1已处理
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
     * 创建人
     *
     * @mbggenerated
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}