package com.hengyunsoft.platform.mt.entity.punchclock.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class PunchClock extends BaseEntity<Long> implements Serializable {
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
     * 打卡日期
     *
     * @mbggenerated
     */
    private Date clockDate;

    /**
     * 签到时间
     *
     * @mbggenerated
     */
    private Date signInTime;

    /**
     * 签退时间
     *
     * @mbggenerated
     */
    private Date signOffTime;

    /**
     * 考勤类型:1,内勤；2，外勤
     *
     * @mbggenerated
     */
    private Integer adceType;

    /**
     * 签到状态:1,正常；2，迟到；3，早退
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 是否自动签到:1,手动；2，自动
     *
     * @mbggenerated
     */
    private Integer autoSignInFlag;

    /**
     * 是否自动签退:1,手动；2，自动
     *
     * @mbggenerated
     */
    private Integer autoSignOffFlag;

    /**
     * 签到经度
     *
     * @mbggenerated
     */
    private String signInLng;

    /**
     * 签到纬度
     *
     * @mbggenerated
     */
    private String signInLat;

    /**
     * 签到地点
     *
     * @mbggenerated
     */
    private String signLocation;

    /**
     * 签退经度
     *
     * @mbggenerated
     */
    private String signOffLng;

    /**
     * 签退纬度
     *
     * @mbggenerated
     */
    private String signOffLat;

    /**
     * 签退地点
     *
     * @mbggenerated
     */
    private String signOffLocation;

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
     * 签到时间
     *
     * @mbggenerated
     */
    public Date getSignInTime() {
        return signInTime;
    }

    /**
     * 签到时间
     *
     * @mbggenerated
     */
    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    /**
     * 签退时间
     *
     * @mbggenerated
     */
    public Date getSignOffTime() {
        return signOffTime;
    }

    /**
     * 签退时间
     *
     * @mbggenerated
     */
    public void setSignOffTime(Date signOffTime) {
        this.signOffTime = signOffTime;
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
     * 是否自动签到:1,手动；2，自动
     *
     * @mbggenerated
     */
    public Integer getAutoSignInFlag() {
        return autoSignInFlag;
    }

    /**
     * 是否自动签到:1,手动；2，自动
     *
     * @mbggenerated
     */
    public void setAutoSignInFlag(Integer autoSignInFlag) {
        this.autoSignInFlag = autoSignInFlag;
    }

    /**
     * 是否自动签退:1,手动；2，自动
     *
     * @mbggenerated
     */
    public Integer getAutoSignOffFlag() {
        return autoSignOffFlag;
    }

    /**
     * 是否自动签退:1,手动；2，自动
     *
     * @mbggenerated
     */
    public void setAutoSignOffFlag(Integer autoSignOffFlag) {
        this.autoSignOffFlag = autoSignOffFlag;
    }

    /**
     * 签到经度
     *
     * @mbggenerated
     */
    public String getSignInLng() {
        return signInLng;
    }

    /**
     * 签到经度
     *
     * @mbggenerated
     */
    public void setSignInLng(String signInLng) {
        this.signInLng = signInLng == null ? null : signInLng.trim();
    }

    /**
     * 签到纬度
     *
     * @mbggenerated
     */
    public String getSignInLat() {
        return signInLat;
    }

    /**
     * 签到纬度
     *
     * @mbggenerated
     */
    public void setSignInLat(String signInLat) {
        this.signInLat = signInLat == null ? null : signInLat.trim();
    }

    /**
     * 签到地点
     *
     * @mbggenerated
     */
    public String getSignLocation() {
        return signLocation;
    }

    /**
     * 签到地点
     *
     * @mbggenerated
     */
    public void setSignLocation(String signLocation) {
        this.signLocation = signLocation == null ? null : signLocation.trim();
    }

    /**
     * 签退经度
     *
     * @mbggenerated
     */
    public String getSignOffLng() {
        return signOffLng;
    }

    /**
     * 签退经度
     *
     * @mbggenerated
     */
    public void setSignOffLng(String signOffLng) {
        this.signOffLng = signOffLng == null ? null : signOffLng.trim();
    }

    /**
     * 签退纬度
     *
     * @mbggenerated
     */
    public String getSignOffLat() {
        return signOffLat;
    }

    /**
     * 签退纬度
     *
     * @mbggenerated
     */
    public void setSignOffLat(String signOffLat) {
        this.signOffLat = signOffLat == null ? null : signOffLat.trim();
    }

    /**
     * 签退地点
     *
     * @mbggenerated
     */
    public String getSignOffLocation() {
        return signOffLocation;
    }

    /**
     * 签退地点
     *
     * @mbggenerated
     */
    public void setSignOffLocation(String signOffLocation) {
        this.signOffLocation = signOffLocation == null ? null : signOffLocation.trim();
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