package com.hengyunsoft.platform.developer.entity.fast.meet.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class Meet extends CommonBaseEntity<Long> implements Serializable {
    /**
     * ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 会议名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 会议开始时间
     *
     * @mbggenerated
     */
    private Date startTime;

    /**
     * 会议结束时间
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     * 会议地点
     *
     * @mbggenerated
     */
    private String address;

    /**
     * 会议主持人
     *
     * @mbggenerated
     */
    private String moderator;

    /**
     * 出席市领导
     *
     * @mbggenerated
     */
    private String joinLeader;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * 会议是否取消(1:是，2：否)
     *
     * @mbggenerated
     */
    private Short cancel;

    /**
     * 取消原因
     *
     * @mbggenerated
     */
    private String cancelReason;

    /**
     * 取消时间
     *
     * @mbggenerated
     */
    private Date cancelTime;

    /**
     * 取消人
     *
     * @mbggenerated
     */
    private Long cancelUser;

    /**
     * 可通知状态（1：可通知，2：不可以通知）
     *
     * @mbggenerated
     */
    private Short noticeStatus;

    /**
     * 会议状态(1：通知中，2：部分确认，3：已全部确认，4：已取消，5：部分拒绝)
     *
     * @mbggenerated
     */
    private Short meetStatus;

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

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    private String appId;

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
     * 会议名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 会议名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 会议开始时间
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 会议开始时间
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 会议结束时间
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 会议结束时间
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 会议地点
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * 会议地点
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 会议主持人
     *
     * @mbggenerated
     */
    public String getModerator() {
        return moderator;
    }

    /**
     * 会议主持人
     *
     * @mbggenerated
     */
    public void setModerator(String moderator) {
        this.moderator = moderator == null ? null : moderator.trim();
    }

    /**
     * 出席市领导
     *
     * @mbggenerated
     */
    public String getJoinLeader() {
        return joinLeader;
    }

    /**
     * 出席市领导
     *
     * @mbggenerated
     */
    public void setJoinLeader(String joinLeader) {
        this.joinLeader = joinLeader == null ? null : joinLeader.trim();
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 会议是否取消(1:是，2：否)
     *
     * @mbggenerated
     */
    public Short getCancel() {
        return cancel;
    }

    /**
     * 会议是否取消(1:是，2：否)
     *
     * @mbggenerated
     */
    public void setCancel(Short cancel) {
        this.cancel = cancel;
    }

    /**
     * 取消原因
     *
     * @mbggenerated
     */
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * 取消原因
     *
     * @mbggenerated
     */
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
    }

    /**
     * 取消时间
     *
     * @mbggenerated
     */
    public Date getCancelTime() {
        return cancelTime;
    }

    /**
     * 取消时间
     *
     * @mbggenerated
     */
    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    /**
     * 取消人
     *
     * @mbggenerated
     */
    public Long getCancelUser() {
        return cancelUser;
    }

    /**
     * 取消人
     *
     * @mbggenerated
     */
    public void setCancelUser(Long cancelUser) {
        this.cancelUser = cancelUser;
    }

    /**
     * 可通知状态（1：可通知，2：不可以通知）
     *
     * @mbggenerated
     */
    public Short getNoticeStatus() {
        return noticeStatus;
    }

    /**
     * 可通知状态（1：可通知，2：不可以通知）
     *
     * @mbggenerated
     */
    public void setNoticeStatus(Short noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    /**
     * 会议状态(1：通知中，2：部分确认，3：已全部确认，4：已取消，5：部分拒绝)
     *
     * @mbggenerated
     */
    public Short getMeetStatus() {
        return meetStatus;
    }

    /**
     * 会议状态(1：通知中，2：部分确认，3：已全部确认，4：已取消，5：部分拒绝)
     *
     * @mbggenerated
     */
    public void setMeetStatus(Short meetStatus) {
        this.meetStatus = meetStatus;
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
}