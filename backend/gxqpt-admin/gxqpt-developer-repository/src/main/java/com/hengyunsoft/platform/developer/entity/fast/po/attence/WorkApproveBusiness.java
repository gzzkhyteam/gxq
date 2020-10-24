package com.hengyunsoft.platform.developer.entity.fast.po.attence;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class WorkApproveBusiness extends BaseEntity<Long> implements Serializable {
    /**
     * 请假审批主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 审批主键（b_bg_work_approve.ID）
     *
     * @mbggenerated
     */
    private Long aproveId;

    /**
     * 出差类型
     *
     * @mbggenerated
     */
    private String businessType;

    private String imgUrl;

    /**
     * 工作代理人
     *
     * @mbggenerated
     */
    private Long workAgent;

    /**
     * 出差地址类型（1：省内，2：省外）
     *
     * @mbggenerated
     */
    private Integer addrType;

    /**
     * 出差地点
     *
     * @mbggenerated
     */
    private String businessAddr;

    /**
     * 交通工具
     *
     * @mbggenerated
     */
    private String businessVehicle;

    /**
     * 随行人员
     *
     * @mbggenerated
     */
    private String accompanyUser;

    /**
     * 随行人员电话
     *
     * @mbggenerated
     */
    private String accompanyUserPhone;

    /**
     * 培训名称
     *
     * @mbggenerated
     */
    private String trainName;

    /**
     * 出差开始时间
     *
     * @mbggenerated
     */
    private Date startTime;

    /**
     * 出差结束时间
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     * 出差时长
     *
     * @mbggenerated
     */
    private Float busHour;

    /**
     * 出差事由
     *
     * @mbggenerated
     */
    private String businessRenson;

    /**
     * 是否申请差旅费（1：是，2：否）
     *
     * @mbggenerated
     */
    private Integer travelApply;

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
     * 请假审批主键
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 请假审批主键
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 审批主键（b_bg_work_approve.ID）
     *
     * @mbggenerated
     */
    public Long getAproveId() {
        return aproveId;
    }

    /**
     * 审批主键（b_bg_work_approve.ID）
     *
     * @mbggenerated
     */
    public void setAproveId(Long aproveId) {
        this.aproveId = aproveId;
    }

    /**
     * 出差类型
     *
     * @mbggenerated
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 出差类型
     *
     * @mbggenerated
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 工作代理人
     *
     * @mbggenerated
     */
    public Long getWorkAgent() {
        return workAgent;
    }

    /**
     * 工作代理人
     *
     * @mbggenerated
     */
    public void setWorkAgent(Long workAgent) {
        this.workAgent = workAgent;
    }

    /**
     * 出差地址类型（1：省内，2：省外）
     *
     * @mbggenerated
     */
    public Integer getAddrType() {
        return addrType;
    }

    /**
     * 出差地址类型（1：省内，2：省外）
     *
     * @mbggenerated
     */
    public void setAddrType(Integer addrType) {
        this.addrType = addrType;
    }

    /**
     * 出差地点
     *
     * @mbggenerated
     */
    public String getBusinessAddr() {
        return businessAddr;
    }

    /**
     * 出差地点
     *
     * @mbggenerated
     */
    public void setBusinessAddr(String businessAddr) {
        this.businessAddr = businessAddr == null ? null : businessAddr.trim();
    }

    /**
     * 交通工具
     *
     * @mbggenerated
     */
    public String getBusinessVehicle() {
        return businessVehicle;
    }

    /**
     * 交通工具
     *
     * @mbggenerated
     */
    public void setBusinessVehicle(String businessVehicle) {
        this.businessVehicle = businessVehicle == null ? null : businessVehicle.trim();
    }

    /**
     * 随行人员
     *
     * @mbggenerated
     */
    public String getAccompanyUser() {
        return accompanyUser;
    }

    /**
     * 随行人员
     *
     * @mbggenerated
     */
    public void setAccompanyUser(String accompanyUser) {
        this.accompanyUser = accompanyUser == null ? null : accompanyUser.trim();
    }

    /**
     * 随行人员电话
     *
     * @mbggenerated
     */
    public String getAccompanyUserPhone() {
        return accompanyUserPhone;
    }

    /**
     * 随行人员电话
     *
     * @mbggenerated
     */
    public void setAccompanyUserPhone(String accompanyUserPhone) {
        this.accompanyUserPhone = accompanyUserPhone == null ? null : accompanyUserPhone.trim();
    }

    /**
     * 培训名称
     *
     * @mbggenerated
     */
    public String getTrainName() {
        return trainName;
    }

    /**
     * 培训名称
     *
     * @mbggenerated
     */
    public void setTrainName(String trainName) {
        this.trainName = trainName == null ? null : trainName.trim();
    }

    /**
     * 出差开始时间
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 出差开始时间
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 出差结束时间
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 出差结束时间
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 出差时长
     *
     * @mbggenerated
     */
    public Float getBusHour() {
        return busHour;
    }

    /**
     * 出差时长
     *
     * @mbggenerated
     */
    public void setBusHour(Float busHour) {
        this.busHour = busHour;
    }

    /**
     * 出差事由
     *
     * @mbggenerated
     */
    public String getBusinessRenson() {
        return businessRenson;
    }

    /**
     * 出差事由
     *
     * @mbggenerated
     */
    public void setBusinessRenson(String businessRenson) {
        this.businessRenson = businessRenson == null ? null : businessRenson.trim();
    }

    /**
     * 是否申请差旅费（1：是，2：否）
     *
     * @mbggenerated
     */
    public Integer getTravelApply() {
        return travelApply;
    }

    /**
     * 是否申请差旅费（1：是，2：否）
     *
     * @mbggenerated
     */
    public void setTravelApply(Integer travelApply) {
        this.travelApply = travelApply;
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