package com.hengyunsoft.platform.warn.entity.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class GxqptWarnCur extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 预警标题
     *
     * @mbggenerated
     */
    private String title;

    /**
     * 预警内容
     *
     * @mbggenerated
     */
    private String content;

    /**
     * 预警级别
     *
     * @mbggenerated
     */
    private Integer level;

    /**
     * 平台是否可处理 1、可处理0、不可处理
     *
     * @mbggenerated
     */
    private Boolean isHandle;

    /**
     * 应用处理回调地址
     *
     * @mbggenerated
     */
    private String callbackUrl;

    /**
     * 发送时间
     *
     * @mbggenerated
     */
    private String sendtime;

    /**
     * 接收人id
     *
     * @mbggenerated
     */
    private Long sendeeId;

    /**
     * 责任id
     *
     * @mbggenerated
     */
    private Long dutyId;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private String createUser;

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
    private String updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 预警标题
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * 预警标题
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 预警内容
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 预警内容
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 预警级别
     *
     * @mbggenerated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 预警级别
     *
     * @mbggenerated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 平台是否可处理 1、可处理0、不可处理
     *
     * @mbggenerated
     */
    public Boolean getIsHandle() {
        return isHandle;
    }

    /**
     * 平台是否可处理 1、可处理0、不可处理
     *
     * @mbggenerated
     */
    public void setIsHandle(Boolean isHandle) {
        this.isHandle = isHandle;
    }

    /**
     * 应用处理回调地址
     *
     * @mbggenerated
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * 应用处理回调地址
     *
     * @mbggenerated
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl == null ? null : callbackUrl.trim();
    }

    /**
     * 发送时间
     *
     * @mbggenerated
     */
    public String getSendtime() {
        return sendtime;
    }

    /**
     * 发送时间
     *
     * @mbggenerated
     */
    public void setSendtime(String sendtime) {
        this.sendtime = sendtime == null ? null : sendtime.trim();
    }

    /**
     * 接收人id
     *
     * @mbggenerated
     */
    public Long getSendeeId() {
        return sendeeId;
    }

    /**
     * 接收人id
     *
     * @mbggenerated
     */
    public void setSendeeId(Long sendeeId) {
        this.sendeeId = sendeeId;
    }

    /**
     * 责任id
     *
     * @mbggenerated
     */
    public Long getDutyId() {
        return dutyId;
    }

    /**
     * 责任id
     *
     * @mbggenerated
     */
    public void setDutyId(Long dutyId) {
        this.dutyId = dutyId;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
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
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
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