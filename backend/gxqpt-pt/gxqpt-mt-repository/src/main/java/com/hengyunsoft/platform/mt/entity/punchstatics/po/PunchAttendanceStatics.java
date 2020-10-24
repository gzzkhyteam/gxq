package com.hengyunsoft.platform.mt.entity.punchstatics.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class PunchAttendanceStatics extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    private String unitId;

    /**
     * 统计年(yyyy)
     *
     * @mbggenerated
     */
    private String attYear;

    /**
     * 统计月(yyyy-mm)
     *
     * @mbggenerated
     */
    private String attMonth;

    /**
     * 统计日(yyyy-MM-dd)
     *
     * @mbggenerated
     */
    private String attDay;

    /**
     * 是否放假(0不放假，1放假)
     *
     * @mbggenerated
     */
    private Integer isholiday;

    /**
     * 外勤（单位小时）
     *
     * @mbggenerated
     */
    private Double outHous;

    /**
     * 加班（单位小时）
     *
     * @mbggenerated
     */
    private Double workHous;

    /**
     * 请假（单位小时）
     *
     * @mbggenerated
     */
    private Double leaveHous;

    /**
     * 出差（单位小时）
     *
     * @mbggenerated
     */
    private Double travelHous;

    /**
     * 迟到（单位小时）
     *
     * @mbggenerated
     */
    private Double lateHour;

    /**
     * 早退（单位小时）
     *
     * @mbggenerated
     */
    private Double earlyHour;

    /**
     * 矿工(单位次数)
     *
     * @mbggenerated
     */
    private Integer minerCount;

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
     * 统计年(yyyy)
     *
     * @mbggenerated
     */
    public String getAttYear() {
        return attYear;
    }

    /**
     * 统计年(yyyy)
     *
     * @mbggenerated
     */
    public void setAttYear(String attYear) {
        this.attYear = attYear == null ? null : attYear.trim();
    }

    /**
     * 统计月(yyyy-mm)
     *
     * @mbggenerated
     */
    public String getAttMonth() {
        return attMonth;
    }

    /**
     * 统计月(yyyy-mm)
     *
     * @mbggenerated
     */
    public void setAttMonth(String attMonth) {
        this.attMonth = attMonth == null ? null : attMonth.trim();
    }

    /**
     * 统计日(yyyy-MM-dd)
     *
     * @mbggenerated
     */
    public String getAttDay() {
        return attDay;
    }

    /**
     * 统计日(yyyy-MM-dd)
     *
     * @mbggenerated
     */
    public void setAttDay(String attDay) {
        this.attDay = attDay == null ? null : attDay.trim();
    }

    /**
     * 是否放假(0不放假，1放假)
     *
     * @mbggenerated
     */
    public Integer getIsholiday() {
        return isholiday;
    }

    /**
     * 是否放假(0不放假，1放假)
     *
     * @mbggenerated
     */
    public void setIsholiday(Integer isholiday) {
        this.isholiday = isholiday;
    }

    /**
     * 外勤（单位小时）
     *
     * @mbggenerated
     */
    public Double getOutHous() {
        return outHous;
    }

    /**
     * 外勤（单位小时）
     *
     * @mbggenerated
     */
    public void setOutHous(Double outHous) {
        this.outHous = outHous;
    }

    /**
     * 加班（单位小时）
     *
     * @mbggenerated
     */
    public Double getWorkHous() {
        return workHous;
    }

    /**
     * 加班（单位小时）
     *
     * @mbggenerated
     */
    public void setWorkHous(Double workHous) {
        this.workHous = workHous;
    }

    /**
     * 请假（单位小时）
     *
     * @mbggenerated
     */
    public Double getLeaveHous() {
        return leaveHous;
    }

    /**
     * 请假（单位小时）
     *
     * @mbggenerated
     */
    public void setLeaveHous(Double leaveHous) {
        this.leaveHous = leaveHous;
    }

    /**
     * 出差（单位小时）
     *
     * @mbggenerated
     */
    public Double getTravelHous() {
        return travelHous;
    }

    /**
     * 出差（单位小时）
     *
     * @mbggenerated
     */
    public void setTravelHous(Double travelHous) {
        this.travelHous = travelHous;
    }

    /**
     * 迟到（单位小时）
     *
     * @mbggenerated
     */
    public Double getLateHour() {
        return lateHour;
    }

    /**
     * 迟到（单位小时）
     *
     * @mbggenerated
     */
    public void setLateHour(Double lateHour) {
        this.lateHour = lateHour;
    }

    /**
     * 早退（单位小时）
     *
     * @mbggenerated
     */
    public Double getEarlyHour() {
        return earlyHour;
    }

    /**
     * 早退（单位小时）
     *
     * @mbggenerated
     */
    public void setEarlyHour(Double earlyHour) {
        this.earlyHour = earlyHour;
    }

    /**
     * 矿工(单位次数)
     *
     * @mbggenerated
     */
    public Integer getMinerCount() {
        return minerCount;
    }

    /**
     * 矿工(单位次数)
     *
     * @mbggenerated
     */
    public void setMinerCount(Integer minerCount) {
        this.minerCount = minerCount;
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