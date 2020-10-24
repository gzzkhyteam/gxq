package com.hengyunsoft.platform.ops.entity.alarm.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class AlarmInformation extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 系统id
     *
     * @mbggenerated
     */
    private String systemId;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    private String systemName;

    /**
     * 状态:1未处理，2已处理
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 详情跳转地址
     *
     * @mbggenerated
     */
    private String detailsUrl;

    /**
     * 申请类别
     *
     * @mbggenerated
     */
    private String applyType;

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    private String applyCode;

    /**
     * 告警规则id
     *
     * @mbggenerated
     */
    private Long ruleId;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 系统id
     *
     * @mbggenerated
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * 系统id
     *
     * @mbggenerated
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    /**
     * 状态:1未处理，2已处理
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态:1未处理，2已处理
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 详情跳转地址
     *
     * @mbggenerated
     */
    public String getDetailsUrl() {
        return detailsUrl;
    }

    /**
     * 详情跳转地址
     *
     * @mbggenerated
     */
    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl == null ? null : detailsUrl.trim();
    }

    /**
     * 申请类别
     *
     * @mbggenerated
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * 申请类别
     *
     * @mbggenerated
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    public String getApplyCode() {
        return applyCode;
    }

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode == null ? null : applyCode.trim();
    }

    /**
     * 告警规则id
     *
     * @mbggenerated
     */
    public Long getRuleId() {
        return ruleId;
    }

    /**
     * 告警规则id
     *
     * @mbggenerated
     */
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
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
     * 更新人
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}