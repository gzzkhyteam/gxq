package com.hengyunsoft.platform.ops.entity.alarm.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class AlarmRuleSettings extends BaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 告警名称
     *
     * @mbggenerated
     */
    private String alarmName;

    /**
     * 告警级别
     *
     * @mbggenerated
     */
    private Integer alarmLevel;

    /**
     * 告警类型
     *
     * @mbggenerated
     */
    private Integer alarmType;

    /**
     * 任务类型
     *
     * @mbggenerated
     */
    private Integer taskType;

    /**
     * 预警天数
     *
     * @mbggenerated
     */
    private Integer day;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 告警名称
     *
     * @mbggenerated
     */
    public String getAlarmName() {
        return alarmName;
    }

    /**
     * 告警名称
     *
     * @mbggenerated
     */
    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName == null ? null : alarmName.trim();
    }

    /**
     * 告警级别
     *
     * @mbggenerated
     */
    public Integer getAlarmLevel() {
        return alarmLevel;
    }

    /**
     * 告警级别
     *
     * @mbggenerated
     */
    public void setAlarmLevel(Integer alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    /**
     * 告警类型
     *
     * @mbggenerated
     */
    public Integer getAlarmType() {
        return alarmType;
    }

    /**
     * 告警类型
     *
     * @mbggenerated
     */
    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    /**
     * 任务类型
     *
     * @mbggenerated
     */
    public Integer getTaskType() {
        return taskType;
    }

    /**
     * 任务类型
     *
     * @mbggenerated
     */
    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    /**
     * 预警天数
     *
     * @mbggenerated
     */
    public Integer getDay() {
        return day;
    }

    /**
     * 预警天数
     *
     * @mbggenerated
     */
    public void setDay(Integer day) {
        this.day = day;
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