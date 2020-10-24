package com.hengyunsoft.platform.mt.entity.feedback.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class FeedBack extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    private Long appliId;

    /**
     * 反馈标题
     *
     * @mbggenerated
     */
    private String fbTitle;

    /**
     * 反馈内容
     *
     * @mbggenerated
     */
    private String fbContent;

    /**
     * 紧急程度(1普通，2紧急，3非常紧急)
     *
     * @mbggenerated
     */
    private Integer fbEmergency;

    /**
     * 处理状态（1未处理，2已处理,3已经关闭）
     *
     * @mbggenerated
     */
    private Integer fbState;

    /**
     * 关闭人
     *
     * @mbggenerated
     */
    private Long fbCloseId;

    /**
     * 关闭人姓名
     *
     * @mbggenerated
     */
    private String fbCloseName;

    /**
     * 关闭时间
     *
     * @mbggenerated
     */
    private Date fbCloseTime;

    /**
     * 创建人姓名
     *
     * @mbggenerated
     */
    private String createUserName;

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
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

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
     * 应用id
     *
     * @mbggenerated
     */
    public Long getAppliId() {
        return appliId;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public void setAppliId(Long appliId) {
        this.appliId = appliId;
    }

    /**
     * 反馈标题
     *
     * @mbggenerated
     */
    public String getFbTitle() {
        return fbTitle;
    }

    /**
     * 反馈标题
     *
     * @mbggenerated
     */
    public void setFbTitle(String fbTitle) {
        this.fbTitle = fbTitle == null ? null : fbTitle.trim();
    }

    /**
     * 反馈内容
     *
     * @mbggenerated
     */
    public String getFbContent() {
        return fbContent;
    }

    /**
     * 反馈内容
     *
     * @mbggenerated
     */
    public void setFbContent(String fbContent) {
        this.fbContent = fbContent == null ? null : fbContent.trim();
    }

    /**
     * 紧急程度(1普通，2紧急，3非常紧急)
     *
     * @mbggenerated
     */
    public Integer getFbEmergency() {
        return fbEmergency;
    }

    /**
     * 紧急程度(1普通，2紧急，3非常紧急)
     *
     * @mbggenerated
     */
    public void setFbEmergency(Integer fbEmergency) {
        this.fbEmergency = fbEmergency;
    }

    /**
     * 处理状态（1未处理，2已处理,3已经关闭）
     *
     * @mbggenerated
     */
    public Integer getFbState() {
        return fbState;
    }

    /**
     * 处理状态（1未处理，2已处理,3已经关闭）
     *
     * @mbggenerated
     */
    public void setFbState(Integer fbState) {
        this.fbState = fbState;
    }

    /**
     * 关闭人
     *
     * @mbggenerated
     */
    public Long getFbCloseId() {
        return fbCloseId;
    }

    /**
     * 关闭人
     *
     * @mbggenerated
     */
    public void setFbCloseId(Long fbCloseId) {
        this.fbCloseId = fbCloseId;
    }

    /**
     * 关闭人姓名
     *
     * @mbggenerated
     */
    public String getFbCloseName() {
        return fbCloseName;
    }

    /**
     * 关闭人姓名
     *
     * @mbggenerated
     */
    public void setFbCloseName(String fbCloseName) {
        this.fbCloseName = fbCloseName == null ? null : fbCloseName.trim();
    }

    /**
     * 关闭时间
     *
     * @mbggenerated
     */
    public Date getFbCloseTime() {
        return fbCloseTime;
    }

    /**
     * 关闭时间
     *
     * @mbggenerated
     */
    public void setFbCloseTime(Date fbCloseTime) {
        this.fbCloseTime = fbCloseTime;
    }

    /**
     * 创建人姓名
     *
     * @mbggenerated
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 创建人姓名
     *
     * @mbggenerated
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
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
}