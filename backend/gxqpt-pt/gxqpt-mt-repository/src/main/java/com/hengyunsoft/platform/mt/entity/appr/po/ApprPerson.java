package com.hengyunsoft.platform.mt.entity.appr.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ApprPerson extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 申请Id
     *
     * @mbggenerated
     */
    private Long applyId;

    /**
     * 审批（抄送）人Id
     *
     * @mbggenerated
     */
    private Long apprUserId;

    /**
     * 审批（抄送）人姓名
     *
     * @mbggenerated
     */
    private String apprUserName;
    /***
     * 审批（抄送）人 照片
     */
    private  String photo;

    /**
     * 审批人顺序
     *
     * @mbggenerated
     */
    private Integer apprUserIndex;

    /**
     * 人员类型(1:审批人，2:抄送人)
     *
     * @mbggenerated
     */
    private Integer userType;

    /**
     * 是否已读(0:未读，1:已读)
     *
     * @mbggenerated
     */
    private Integer isRead;

    /**
     * 是否同意(0:是，1:否)
     *
     * @mbggenerated
     */
    private Integer agree;

    /**
     * 审批意见
     *
     * @mbggenerated
     */
    private String apprOpinion;

    /**
     * 审批时间
     *
     * @mbggenerated
     */
    private Date apprTime;

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
     * 申请Id
     *
     * @mbggenerated
     */
    public Long getApplyId() {
        return applyId;
    }

    /**
     * 申请Id
     *
     * @mbggenerated
     */
    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    /**
     * 审批（抄送）人Id
     *
     * @mbggenerated
     */
    public Long getApprUserId() {
        return apprUserId;
    }

    /**
     * 审批（抄送）人Id
     *
     * @mbggenerated
     */
    public void setApprUserId(Long apprUserId) {
        this.apprUserId = apprUserId;
    }

    /**
     * 审批（抄送）人姓名
     *
     * @mbggenerated
     */
    public String getApprUserName() {
        return apprUserName;
    }

    /**
     * 审批（抄送）人姓名
     *
     * @mbggenerated
     */
    public void setApprUserName(String apprUserName) {
        this.apprUserName = apprUserName == null ? null : apprUserName.trim();
    }

    /**
     * 审批人顺序
     *
     * @mbggenerated
     */
    public Integer getApprUserIndex() {
        return apprUserIndex;
    }

    /**
     * 审批人顺序
     *
     * @mbggenerated
     */
    public void setApprUserIndex(Integer apprUserIndex) {
        this.apprUserIndex = apprUserIndex;
    }

    /**
     * 人员类型(1:审批人，2:抄送人)
     *
     * @mbggenerated
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 人员类型(1:审批人，2:抄送人)
     *
     * @mbggenerated
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 是否已读(0:未读，1:已读)
     *
     * @mbggenerated
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * 是否已读(0:未读，1:已读)
     *
     * @mbggenerated
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    /**
     * 是否同意(0:是，1:否)
     *
     * @mbggenerated
     */
    public Integer getAgree() {
        return agree;
    }

    /**
     * 是否同意(0:是，1:否)
     *
     * @mbggenerated
     */
    public void setAgree(Integer agree) {
        this.agree = agree;
    }

    /**
     * 审批意见
     *
     * @mbggenerated
     */
    public String getApprOpinion() {
        return apprOpinion;
    }

    /**
     * 审批意见
     *
     * @mbggenerated
     */
    public void setApprOpinion(String apprOpinion) {
        this.apprOpinion = apprOpinion == null ? null : apprOpinion.trim();
    }

    /**
     * 审批时间
     *
     * @mbggenerated
     */
    public Date getApprTime() {
        return apprTime;
    }

    /**
     * 审批时间
     *
     * @mbggenerated
     */
    public void setApprTime(Date apprTime) {
        this.apprTime = apprTime;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}