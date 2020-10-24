package com.hengyunsoft.platform.admin.entity.base.po;

import com.hengyunsoft.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class HolidayOriginalData extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 编号
     *
     * @mbggenerated
     */
    private String number;

    /**
     * 是否启用：1是，0否
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 节假日名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 故事
     *
     * @mbggenerated
     */
    private String story;

    /**
     * 节假日从哪年开始时间
     *
     * @mbggenerated
     */
    private String starTime;

    /**
     * 节假日从哪年截止时间
     *
     * @mbggenerated
     */
    private String endTime;

    /**
     * 开始月
     *
     * @mbggenerated
     */
    private String month;

    /**
     * 日
     *
     * @mbggenerated
     */
    private String day;

    /**
     * 节假日天数
     *
     * @mbggenerated
     */
    private String holidayDays;

    /**
     * 日历类型:1阳历，0阳历
     *
     * @mbggenerated
     */
    private String calendarType;

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
     * 编号
     *
     * @mbggenerated
     */
    public String getNumber() {
        return number;
    }

    /**
     * 编号
     *
     * @mbggenerated
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * 是否启用：1是，0否
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 是否启用：1是，0否
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 节假日名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 节假日名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 故事
     *
     * @mbggenerated
     */
    public String getStory() {
        return story;
    }

    /**
     * 故事
     *
     * @mbggenerated
     */
    public void setStory(String story) {
        this.story = story == null ? null : story.trim();
    }

    /**
     * 节假日从哪年开始时间
     *
     * @mbggenerated
     */
    public String getStarTime() {
        return starTime;
    }

    /**
     * 节假日从哪年开始时间
     *
     * @mbggenerated
     */
    public void setStarTime(String starTime) {
        this.starTime = starTime == null ? null : starTime.trim();
    }

    /**
     * 节假日从哪年截止时间
     *
     * @mbggenerated
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 节假日从哪年截止时间
     *
     * @mbggenerated
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * 开始月
     *
     * @mbggenerated
     */
    public String getMonth() {
        return month;
    }

    /**
     * 开始月
     *
     * @mbggenerated
     */
    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    /**
     * 日
     *
     * @mbggenerated
     */
    public String getDay() {
        return day;
    }

    /**
     * 日
     *
     * @mbggenerated
     */
    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    /**
     * 节假日天数
     *
     * @mbggenerated
     */
    public String getHolidayDays() {
        return holidayDays;
    }

    /**
     * 节假日天数
     *
     * @mbggenerated
     */
    public void setHolidayDays(String holidayDays) {
        this.holidayDays = holidayDays == null ? null : holidayDays.trim();
    }

    /**
     * 日历类型:1阳历，0阳历
     *
     * @mbggenerated
     */
    public String getCalendarType() {
        return calendarType;
    }

    /**
     * 日历类型:1阳历，0阳历
     *
     * @mbggenerated
     */
    public void setCalendarType(String calendarType) {
        this.calendarType = calendarType == null ? null : calendarType.trim();
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