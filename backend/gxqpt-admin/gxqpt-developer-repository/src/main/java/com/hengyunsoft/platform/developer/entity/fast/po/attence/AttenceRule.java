package com.hengyunsoft.platform.developer.entity.fast.po.attence;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class AttenceRule extends CommonBaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 上班签到时间
     *
     * @mbggenerated
     */
    private String inTime;

    /**
     * 下班签到时间
     *
     * @mbggenerated
     */
    private String outTime;

    /**
     * 迟到界定开始
     *
     * @mbggenerated
     */
    private String laterStartTime;

    /**
     * 迟到界定结束
     *
     * @mbggenerated
     */
    private String laterEndTime;

    /**
     * 午休开始时间
     *
     * @mbggenerated
     */
    private String lunchStartTime;

    /**
     * 午休结束时间
     *
     * @mbggenerated
     */
    private String lunchEndTime;

    /**
     * 矿工界定范围
     *
     * @mbggenerated
     */
    private String absentTimeRange;

    /**
     * 早退界定范围
     *
     * @mbggenerated
     */
    private String leaveTimeRange;

    /**
     * 上班签到距离范围
     *
     * @mbggenerated
     */
    private String distanceRange;

    /**
     * 经度
     *
     * @mbggenerated
     */
    private Double latitude;

    /**
     * 上传文件地址
     *
     * @mbggenerated
     */
    private String uploadUrl;

    /**
     * 纬度
     *
     * @mbggenerated
     */
    private Double longtude;

    /**
     * 签到位置
     *
     * @mbggenerated
     */
    private String location;

    /**
     * 工作日加班计算起始时间
     *
     * @mbggenerated
     */
    private String startTime;

    /**
     * 节假日加班计算系数
     *
     * @mbggenerated
     */
    private Float coefficient;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

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
     * 上班签到时间
     *
     * @mbggenerated
     */
    public String getInTime() {
        return inTime;
    }

    /**
     * 上班签到时间
     *
     * @mbggenerated
     */
    public void setInTime(String inTime) {
        this.inTime = inTime == null ? null : inTime.trim();
    }

    /**
     * 下班签到时间
     *
     * @mbggenerated
     */
    public String getOutTime() {
        return outTime;
    }

    /**
     * 下班签到时间
     *
     * @mbggenerated
     */
    public void setOutTime(String outTime) {
        this.outTime = outTime == null ? null : outTime.trim();
    }

    /**
     * 迟到界定开始
     *
     * @mbggenerated
     */
    public String getLaterStartTime() {
        return laterStartTime;
    }

    /**
     * 迟到界定开始
     *
     * @mbggenerated
     */
    public void setLaterStartTime(String laterStartTime) {
        this.laterStartTime = laterStartTime == null ? null : laterStartTime.trim();
    }

    /**
     * 迟到界定结束
     *
     * @mbggenerated
     */
    public String getLaterEndTime() {
        return laterEndTime;
    }

    /**
     * 迟到界定结束
     *
     * @mbggenerated
     */
    public void setLaterEndTime(String laterEndTime) {
        this.laterEndTime = laterEndTime == null ? null : laterEndTime.trim();
    }

    /**
     * 午休开始时间
     *
     * @mbggenerated
     */
    public String getLunchStartTime() {
        return lunchStartTime;
    }

    /**
     * 午休开始时间
     *
     * @mbggenerated
     */
    public void setLunchStartTime(String lunchStartTime) {
        this.lunchStartTime = lunchStartTime == null ? null : lunchStartTime.trim();
    }

    /**
     * 午休结束时间
     *
     * @mbggenerated
     */
    public String getLunchEndTime() {
        return lunchEndTime;
    }

    /**
     * 午休结束时间
     *
     * @mbggenerated
     */
    public void setLunchEndTime(String lunchEndTime) {
        this.lunchEndTime = lunchEndTime == null ? null : lunchEndTime.trim();
    }

    /**
     * 矿工界定范围
     *
     * @mbggenerated
     */
    public String getAbsentTimeRange() {
        return absentTimeRange;
    }

    /**
     * 矿工界定范围
     *
     * @mbggenerated
     */
    public void setAbsentTimeRange(String absentTimeRange) {
        this.absentTimeRange = absentTimeRange == null ? null : absentTimeRange.trim();
    }

    /**
     * 早退界定范围
     *
     * @mbggenerated
     */
    public String getLeaveTimeRange() {
        return leaveTimeRange;
    }

    /**
     * 早退界定范围
     *
     * @mbggenerated
     */
    public void setLeaveTimeRange(String leaveTimeRange) {
        this.leaveTimeRange = leaveTimeRange == null ? null : leaveTimeRange.trim();
    }

    /**
     * 上班签到距离范围
     *
     * @mbggenerated
     */
    public String getDistanceRange() {
        return distanceRange;
    }

    /**
     * 上班签到距离范围
     *
     * @mbggenerated
     */
    public void setDistanceRange(String distanceRange) {
        this.distanceRange = distanceRange == null ? null : distanceRange.trim();
    }

    /**
     * 经度
     *
     * @mbggenerated
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 经度
     *
     * @mbggenerated
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 上传文件地址
     *
     * @mbggenerated
     */
    public String getUploadUrl() {
        return uploadUrl;
    }

    /**
     * 上传文件地址
     *
     * @mbggenerated
     */
    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl == null ? null : uploadUrl.trim();
    }

    /**
     * 纬度
     *
     * @mbggenerated
     */
    public Double getLongtude() {
        return longtude;
    }

    /**
     * 纬度
     *
     * @mbggenerated
     */
    public void setLongtude(Double longtude) {
        this.longtude = longtude;
    }

    /**
     * 签到位置
     *
     * @mbggenerated
     */
    public String getLocation() {
        return location;
    }

    /**
     * 签到位置
     *
     * @mbggenerated
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 工作日加班计算起始时间
     *
     * @mbggenerated
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 工作日加班计算起始时间
     *
     * @mbggenerated
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * 节假日加班计算系数
     *
     * @mbggenerated
     */
    public Float getCoefficient() {
        return coefficient;
    }

    /**
     * 节假日加班计算系数
     *
     * @mbggenerated
     */
    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
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