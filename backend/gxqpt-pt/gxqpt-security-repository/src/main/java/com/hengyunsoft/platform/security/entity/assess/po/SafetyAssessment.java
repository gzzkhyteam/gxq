package com.hengyunsoft.platform.security.entity.assess.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class SafetyAssessment extends CommonBaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    private String applicationName;

    /**
     * 建设单位
     *
     * @mbggenerated
     */
    private String company;

    /**
     * 承建商
     *
     * @mbggenerated
     */
    private String contractor;

    private Date createTime;

    private Long createUser;

    private Date updateTime;

    private Long updateUser;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName == null ? null : applicationName.trim();
    }

    /**
     * 建设单位
     *
     * @mbggenerated
     */
    public String getCompany() {
        return company;
    }

    /**
     * 建设单位
     *
     * @mbggenerated
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * 承建商
     *
     * @mbggenerated
     */
    public String getContractor() {
        return contractor;
    }

    /**
     * 承建商
     *
     * @mbggenerated
     */
    public void setContractor(String contractor) {
        this.contractor = contractor == null ? null : contractor.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}