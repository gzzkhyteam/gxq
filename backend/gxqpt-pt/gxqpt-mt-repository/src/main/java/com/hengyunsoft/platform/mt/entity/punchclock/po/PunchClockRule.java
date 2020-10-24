package com.hengyunsoft.platform.mt.entity.punchclock.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class PunchClockRule extends BaseEntity<Long> implements Serializable {
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
     * 签到时间
     *
     * @mbggenerated
     */
    private String inTime;

    /**
     * 签退时间
     *
     * @mbggenerated
     */
    private String outTime;

    /**
     * 午休开始时间
     *
     * @mbggenerated
     */
    private String startTime;

    /**
     * 午休结束时间
     *
     * @mbggenerated
     */
    private String endTime;

    /**
     * 签到距离范围(米)
     *
     * @mbggenerated
     */
    private Integer distanceRange;

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
     * 签到时间
     *
     * @mbggenerated
     */
    public String getInTime() {
        return inTime;
    }

    /**
     * 签到时间
     *
     * @mbggenerated
     */
    public void setInTime(String inTime) {
        this.inTime = inTime == null ? null : inTime.trim();
    }

    /**
     * 签退时间
     *
     * @mbggenerated
     */
    public String getOutTime() {
        return outTime;
    }

    /**
     * 签退时间
     *
     * @mbggenerated
     */
    public void setOutTime(String outTime) {
        this.outTime = outTime == null ? null : outTime.trim();
    }

    /**
     * 午休开始时间
     *
     * @mbggenerated
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 午休开始时间
     *
     * @mbggenerated
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * 午休结束时间
     *
     * @mbggenerated
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 午休结束时间
     *
     * @mbggenerated
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * 签到距离范围(米)
     *
     * @mbggenerated
     */
    public Integer getDistanceRange() {
        return distanceRange;
    }

    /**
     * 签到距离范围(米)
     *
     * @mbggenerated
     */
    public void setDistanceRange(Integer distanceRange) {
        this.distanceRange = distanceRange;
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