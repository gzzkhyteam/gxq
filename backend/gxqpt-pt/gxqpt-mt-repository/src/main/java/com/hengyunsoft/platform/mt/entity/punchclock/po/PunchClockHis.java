package com.hengyunsoft.platform.mt.entity.punchclock.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class PunchClockHis extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    private String unitId;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 打卡类型:1,签到；2，签退
     *
     * @mbggenerated
     */
    private Integer clockType;

    /**
     * 打卡日期
     *
     * @mbggenerated
     */
    private Date clockDate;

    /**
     * 打卡时间
     *
     * @mbggenerated
     */
    private Date clockTime;

    /**
     * 考勤类型:1,内勤；2，外勤
     *
     * @mbggenerated
     */
    private Integer adceType;

    /**
     * 迟到（早退）说明
     *
     * @mbggenerated
     */
    private String lateReason;

    /**
     * 签到状态:1,正常；2，迟到；3，早退
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 外勤事由
     *
     * @mbggenerated
     */
    private String outterReason;

    /**
     * 是否自动打卡:1,手动；2，自动
     *
     * @mbggenerated
     */
    private Integer autoFlag;

    /**
     * 经度
     *
     * @mbggenerated
     */
    private String lng;

    /**
     * 纬度
     *
     * @mbggenerated
     */
    private String lat;

    /**
     * 打卡地点
     *
     * @mbggenerated
     */
    private String location;

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
     * 单位id
     *
     * @mbggenerated
     */
    public String getUnitId() {
        return unitId;
    }

    /**
     * 单位id
     *
     * @mbggenerated
     */
    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }

    /**
     * 用户id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 打卡类型:1,签到；2，签退
     *
     * @mbggenerated
     */
    public Integer getClockType() {
        return clockType;
    }

    /**
     * 打卡类型:1,签到；2，签退
     *
     * @mbggenerated
     */
    public void setClockType(Integer clockType) {
        this.clockType = clockType;
    }

    /**
     * 打卡日期
     *
     * @mbggenerated
     */
    public Date getClockDate() {
        return clockDate;
    }

    /**
     * 打卡日期
     *
     * @mbggenerated
     */
    public void setClockDate(Date clockDate) {
        this.clockDate = clockDate;
    }

    /**
     * 打卡时间
     *
     * @mbggenerated
     */
    public Date getClockTime() {
        return clockTime;
    }

    /**
     * 打卡时间
     *
     * @mbggenerated
     */
    public void setClockTime(Date clockTime) {
        this.clockTime = clockTime;
    }

    /**
     * 考勤类型:1,内勤；2，外勤
     *
     * @mbggenerated
     */
    public Integer getAdceType() {
        return adceType;
    }

    /**
     * 考勤类型:1,内勤；2，外勤
     *
     * @mbggenerated
     */
    public void setAdceType(Integer adceType) {
        this.adceType = adceType;
    }

    /**
     * 迟到（早退）说明
     *
     * @mbggenerated
     */
    public String getLateReason() {
        return lateReason;
    }

    /**
     * 迟到（早退）说明
     *
     * @mbggenerated
     */
    public void setLateReason(String lateReason) {
        this.lateReason = lateReason == null ? null : lateReason.trim();
    }

    /**
     * 签到状态:1,正常；2，迟到；3，早退
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 签到状态:1,正常；2，迟到；3，早退
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 外勤事由
     *
     * @mbggenerated
     */
    public String getOutterReason() {
        return outterReason;
    }

    /**
     * 外勤事由
     *
     * @mbggenerated
     */
    public void setOutterReason(String outterReason) {
        this.outterReason = outterReason == null ? null : outterReason.trim();
    }

    /**
     * 是否自动打卡:1,手动；2，自动
     *
     * @mbggenerated
     */
    public Integer getAutoFlag() {
        return autoFlag;
    }

    /**
     * 是否自动打卡:1,手动；2，自动
     *
     * @mbggenerated
     */
    public void setAutoFlag(Integer autoFlag) {
        this.autoFlag = autoFlag;
    }

    /**
     * 经度
     *
     * @mbggenerated
     */
    public String getLng() {
        return lng;
    }

    /**
     * 经度
     *
     * @mbggenerated
     */
    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    /**
     * 纬度
     *
     * @mbggenerated
     */
    public String getLat() {
        return lat;
    }

    /**
     * 纬度
     *
     * @mbggenerated
     */
    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    /**
     * 打卡地点
     *
     * @mbggenerated
     */
    public String getLocation() {
        return location;
    }

    /**
     * 打卡地点
     *
     * @mbggenerated
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
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