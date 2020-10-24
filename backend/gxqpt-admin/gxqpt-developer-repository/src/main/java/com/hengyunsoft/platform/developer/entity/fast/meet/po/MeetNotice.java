package com.hengyunsoft.platform.developer.entity.fast.meet.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class MeetNotice extends CommonBaseEntity<Long> implements Serializable {
    /**
     * ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 会议ID
     *
     * @mbggenerated
     */
    private Long meetId;

    /**
     * 提醒时间
     *
     * @mbggenerated
     */
    private Date noticeTime;

    /**
     * 会议关联人员
     *
     * @mbggenerated
     */
    private Long empId;

    /**
     * 关联人员类型（1：会议发起人，2：参会人员）
     *
     * @mbggenerated
     */
    private Short empType;

    /**
     * 是否参加(0：通知中，1:参加，2：不参加, 3：发起人)
     *
     * @mbggenerated
     */
    private Short joinStatus;

    /**
     * 备注(不参加会议的理由等)
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    private String appId;

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
     * ID
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * ID
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 会议ID
     *
     * @mbggenerated
     */
    public Long getMeetId() {
        return meetId;
    }

    /**
     * 会议ID
     *
     * @mbggenerated
     */
    public void setMeetId(Long meetId) {
        this.meetId = meetId;
    }

    /**
     * 提醒时间
     *
     * @mbggenerated
     */
    public Date getNoticeTime() {
        return noticeTime;
    }

    /**
     * 提醒时间
     *
     * @mbggenerated
     */
    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    /**
     * 会议关联人员
     *
     * @mbggenerated
     */
    public Long getEmpId() {
        return empId;
    }

    /**
     * 会议关联人员
     *
     * @mbggenerated
     */
    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    /**
     * 关联人员类型（1：会议发起人，2：参会人员）
     *
     * @mbggenerated
     */
    public Short getEmpType() {
        return empType;
    }

    /**
     * 关联人员类型（1：会议发起人，2：参会人员）
     *
     * @mbggenerated
     */
    public void setEmpType(Short empType) {
        this.empType = empType;
    }

    /**
     * 是否参加(0：通知中，1:参加，2：不参加, 3：发起人)
     *
     * @mbggenerated
     */
    public Short getJoinStatus() {
        return joinStatus;
    }

    /**
     * 是否参加(0：通知中，1:参加，2：不参加, 3：发起人)
     *
     * @mbggenerated
     */
    public void setJoinStatus(Short joinStatus) {
        this.joinStatus = joinStatus;
    }

    /**
     * 备注(不参加会议的理由等)
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注(不参加会议的理由等)
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
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