package com.hengyunsoft.platform.ops.entity.train.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class TrainManage extends BaseEntity<Long> implements Serializable {
    /**
     * id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 培训类别
     *
     * @mbggenerated
     */
    private String trainType;

    /**
     * 培训名称
     *
     * @mbggenerated
     */
    private String trainName;

    /**
     * 培训地点
     *
     * @mbggenerated
     */
    private String trainAddress;

    /**
     * 培训时间
     *
     * @mbggenerated
     */
    private Date trainTime;

    /**
     * 培训内容
     *
     * @mbggenerated
     */
    private String trainInfo;

    /**
     * 状态
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 培训评分
     *
     * @mbggenerated
     */
    private Long trainSorce;

    /**
     * 评分时间（用于统计分析）
     *
     * @mbggenerated
     */
    private Date scoreTime;

    /**
     * 培训意见
     *
     * @mbggenerated
     */
    private String trainAdvice;

    /**
     * 提交单位
     *
     * @mbggenerated
     */
    private String subDept;

    /**
     * 提交人
     *
     * @mbggenerated
     */
    private String subPerson;

    /**
     * 处理意见
     *
     * @mbggenerated
     */
    private String dealOpinion;

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    private String applyCode;

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
     * id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 培训类别
     *
     * @mbggenerated
     */
    public String getTrainType() {
        return trainType;
    }

    /**
     * 培训类别
     *
     * @mbggenerated
     */
    public void setTrainType(String trainType) {
        this.trainType = trainType == null ? null : trainType.trim();
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
     * 培训地点
     *
     * @mbggenerated
     */
    public String getTrainAddress() {
        return trainAddress;
    }

    /**
     * 培训地点
     *
     * @mbggenerated
     */
    public void setTrainAddress(String trainAddress) {
        this.trainAddress = trainAddress == null ? null : trainAddress.trim();
    }

    /**
     * 培训时间
     *
     * @mbggenerated
     */
    public Date getTrainTime() {
        return trainTime;
    }

    /**
     * 培训时间
     *
     * @mbggenerated
     */
    public void setTrainTime(Date trainTime) {
        this.trainTime = trainTime;
    }

    /**
     * 培训内容
     *
     * @mbggenerated
     */
    public String getTrainInfo() {
        return trainInfo;
    }

    /**
     * 培训内容
     *
     * @mbggenerated
     */
    public void setTrainInfo(String trainInfo) {
        this.trainInfo = trainInfo == null ? null : trainInfo.trim();
    }

    /**
     * 状态
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 培训评分
     *
     * @mbggenerated
     */
    public Long getTrainSorce() {
        return trainSorce;
    }

    /**
     * 培训评分
     *
     * @mbggenerated
     */
    public void setTrainSorce(Long trainSorce) {
        this.trainSorce = trainSorce;
    }

    /**
     * 评分时间（用于统计分析）
     *
     * @mbggenerated
     */
    public Date getScoreTime() {
        return scoreTime;
    }

    /**
     * 评分时间（用于统计分析）
     *
     * @mbggenerated
     */
    public void setScoreTime(Date scoreTime) {
        this.scoreTime = scoreTime;
    }

    /**
     * 培训意见
     *
     * @mbggenerated
     */
    public String getTrainAdvice() {
        return trainAdvice;
    }

    /**
     * 培训意见
     *
     * @mbggenerated
     */
    public void setTrainAdvice(String trainAdvice) {
        this.trainAdvice = trainAdvice == null ? null : trainAdvice.trim();
    }

    /**
     * 提交单位
     *
     * @mbggenerated
     */
    public String getSubDept() {
        return subDept;
    }

    /**
     * 提交单位
     *
     * @mbggenerated
     */
    public void setSubDept(String subDept) {
        this.subDept = subDept == null ? null : subDept.trim();
    }

    /**
     * 提交人
     *
     * @mbggenerated
     */
    public String getSubPerson() {
        return subPerson;
    }

    /**
     * 提交人
     *
     * @mbggenerated
     */
    public void setSubPerson(String subPerson) {
        this.subPerson = subPerson == null ? null : subPerson.trim();
    }

    /**
     * 处理意见
     *
     * @mbggenerated
     */
    public String getDealOpinion() {
        return dealOpinion;
    }

    /**
     * 处理意见
     *
     * @mbggenerated
     */
    public void setDealOpinion(String dealOpinion) {
        this.dealOpinion = dealOpinion == null ? null : dealOpinion.trim();
    }

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    public String getApplyCode() {
        return applyCode;
    }

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode == null ? null : applyCode.trim();
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