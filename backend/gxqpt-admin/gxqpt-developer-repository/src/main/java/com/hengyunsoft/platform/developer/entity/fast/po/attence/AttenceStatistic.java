package com.hengyunsoft.platform.developer.entity.fast.po.attence;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class AttenceStatistic extends CommonBaseEntity<Long> implements Serializable {
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
     * 用户id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 部门编码
     *
     * @mbggenerated
     */
    private String orgCode;

    /**
     * 工作日期
     *
     * @mbggenerated
     */
    private Date workDate;

    /**
     * 加班(小时)
     *
     * @mbggenerated
     */
    private Float extraWork;

    /**
     * 病假(小时)
     *
     * @mbggenerated
     */
    private Float sickLeave;

    /**
     * 事假（小时）
     *
     * @mbggenerated
     */
    private Float affairLeave;

    /**
     * 年休假（小时）
     *
     * @mbggenerated
     */
    private Float annualLeave;

    /**
     * 探亲假（小时）
     *
     * @mbggenerated
     */
    private Float homeLeave;

    /**
     * 婚假（小时）
     *
     * @mbggenerated
     */
    private Float maritalLeave;

    /**
     * 丧假（小时）
     *
     * @mbggenerated
     */
    private Float funeralLeave;

    /**
     * 产假（小时）
     *
     * @mbggenerated
     */
    private Float maternityLeave;

    /**
     * 外派
     *
     * @mbggenerated
     */
    private Float expatriateLeave;

    /**
     * 外勤小时
     *
     * @mbggenerated
     */
    private Float outsideHour;

    /**
     * 旷工（小时）
     *
     * @mbggenerated
     */
    private Float neglectHour;

    /**
     * 旷工次数
     *
     * @mbggenerated
     */
    private Integer neglectNum;

    /**
     * 迟到（小时）
     *
     * @mbggenerated
     */
    private Float lateHour;

    /**
     * 早退小时
     *
     * @mbggenerated
     */
    private Float earlyHour;

    /**
     * 实际工作小时
     *
     * @mbggenerated
     */
    private Float actualHour;

    /**
     * Сʱ
     *
     * @mbggenerated
     */
    private Float businessHour;

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
     * 部门编码
     *
     * @mbggenerated
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * 部门编码
     *
     * @mbggenerated
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * 工作日期
     *
     * @mbggenerated
     */
    public Date getWorkDate() {
        return workDate;
    }

    /**
     * 工作日期
     *
     * @mbggenerated
     */
    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    /**
     * 加班(小时)
     *
     * @mbggenerated
     */
    public Float getExtraWork() {
        return extraWork;
    }

    /**
     * 加班(小时)
     *
     * @mbggenerated
     */
    public void setExtraWork(Float extraWork) {
        this.extraWork = extraWork;
    }

    /**
     * 病假(小时)
     *
     * @mbggenerated
     */
    public Float getSickLeave() {
        return sickLeave;
    }

    /**
     * 病假(小时)
     *
     * @mbggenerated
     */
    public void setSickLeave(Float sickLeave) {
        this.sickLeave = sickLeave;
    }

    /**
     * 事假（小时）
     *
     * @mbggenerated
     */
    public Float getAffairLeave() {
        return affairLeave;
    }

    /**
     * 事假（小时）
     *
     * @mbggenerated
     */
    public void setAffairLeave(Float affairLeave) {
        this.affairLeave = affairLeave;
    }

    /**
     * 年休假（小时）
     *
     * @mbggenerated
     */
    public Float getAnnualLeave() {
        return annualLeave;
    }

    /**
     * 年休假（小时）
     *
     * @mbggenerated
     */
    public void setAnnualLeave(Float annualLeave) {
        this.annualLeave = annualLeave;
    }

    /**
     * 探亲假（小时）
     *
     * @mbggenerated
     */
    public Float getHomeLeave() {
        return homeLeave;
    }

    /**
     * 探亲假（小时）
     *
     * @mbggenerated
     */
    public void setHomeLeave(Float homeLeave) {
        this.homeLeave = homeLeave;
    }

    /**
     * 婚假（小时）
     *
     * @mbggenerated
     */
    public Float getMaritalLeave() {
        return maritalLeave;
    }

    /**
     * 婚假（小时）
     *
     * @mbggenerated
     */
    public void setMaritalLeave(Float maritalLeave) {
        this.maritalLeave = maritalLeave;
    }

    /**
     * 丧假（小时）
     *
     * @mbggenerated
     */
    public Float getFuneralLeave() {
        return funeralLeave;
    }

    /**
     * 丧假（小时）
     *
     * @mbggenerated
     */
    public void setFuneralLeave(Float funeralLeave) {
        this.funeralLeave = funeralLeave;
    }

    /**
     * 产假（小时）
     *
     * @mbggenerated
     */
    public Float getMaternityLeave() {
        return maternityLeave;
    }

    /**
     * 产假（小时）
     *
     * @mbggenerated
     */
    public void setMaternityLeave(Float maternityLeave) {
        this.maternityLeave = maternityLeave;
    }

    /**
     * 外派
     *
     * @mbggenerated
     */
    public Float getExpatriateLeave() {
        return expatriateLeave;
    }

    /**
     * 外派
     *
     * @mbggenerated
     */
    public void setExpatriateLeave(Float expatriateLeave) {
        this.expatriateLeave = expatriateLeave;
    }

    /**
     * 外勤小时
     *
     * @mbggenerated
     */
    public Float getOutsideHour() {
        return outsideHour;
    }

    /**
     * 外勤小时
     *
     * @mbggenerated
     */
    public void setOutsideHour(Float outsideHour) {
        this.outsideHour = outsideHour;
    }

    /**
     * 旷工（小时）
     *
     * @mbggenerated
     */
    public Float getNeglectHour() {
        return neglectHour;
    }

    /**
     * 旷工（小时）
     *
     * @mbggenerated
     */
    public void setNeglectHour(Float neglectHour) {
        this.neglectHour = neglectHour;
    }

    /**
     * 旷工次数
     *
     * @mbggenerated
     */
    public Integer getNeglectNum() {
        return neglectNum;
    }

    /**
     * 旷工次数
     *
     * @mbggenerated
     */
    public void setNeglectNum(Integer neglectNum) {
        this.neglectNum = neglectNum;
    }

    /**
     * 迟到（小时）
     *
     * @mbggenerated
     */
    public Float getLateHour() {
        return lateHour;
    }

    /**
     * 迟到（小时）
     *
     * @mbggenerated
     */
    public void setLateHour(Float lateHour) {
        this.lateHour = lateHour;
    }

    /**
     * 早退小时
     *
     * @mbggenerated
     */
    public Float getEarlyHour() {
        return earlyHour;
    }

    /**
     * 早退小时
     *
     * @mbggenerated
     */
    public void setEarlyHour(Float earlyHour) {
        this.earlyHour = earlyHour;
    }

    /**
     * 实际工作小时
     *
     * @mbggenerated
     */
    public Float getActualHour() {
        return actualHour;
    }

    /**
     * 实际工作小时
     *
     * @mbggenerated
     */
    public void setActualHour(Float actualHour) {
        this.actualHour = actualHour;
    }

    /**
     * Сʱ
     *
     * @mbggenerated
     */
    public Float getBusinessHour() {
        return businessHour;
    }

    /**
     * Сʱ
     *
     * @mbggenerated
     */
    public void setBusinessHour(Float businessHour) {
        this.businessHour = businessHour;
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