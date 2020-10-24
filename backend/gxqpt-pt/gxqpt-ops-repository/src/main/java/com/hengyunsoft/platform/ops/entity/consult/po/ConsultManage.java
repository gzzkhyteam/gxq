package com.hengyunsoft.platform.ops.entity.consult.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ConsultManage extends BaseEntity<Long> implements Serializable {
    /**
     * id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 咨询名称
     *
     * @mbggenerated
     */
    private String consultName;

    /**
     * 咨询时间
     *
     * @mbggenerated
     */
    private Date consultTime;

    /**
     * 咨询内容
     *
     * @mbggenerated
     */
    private String consultInfo;

    /**
     * 状态
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 评分
     *
     * @mbggenerated
     */
    private Long score;

    /**
     * 评分时间（用于统计分析）
     *
     * @mbggenerated
     */
    private Date scoreTime;

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
     * 咨询建议
     *
     * @mbggenerated
     */
    private String consultAdvice;

    /**
     * 处理意见
     *
     * @mbggenerated
     */
    private String dealOpinion;

    /**
     * 服务态度
     *
     * @mbggenerated
     */
    private Long serviceAttitude;

    /**
     * 服务效率
     *
     * @mbggenerated
     */
    private Long serviceEfficiency;

    /**
     * 处理结果
     *
     * @mbggenerated
     */
    private String dealResult;

    /**
     * 服务质量
     *
     * @mbggenerated
     */
    private Long serviceQuality;

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
     * 咨询名称
     *
     * @mbggenerated
     */
    public String getConsultName() {
        return consultName;
    }

    /**
     * 咨询名称
     *
     * @mbggenerated
     */
    public void setConsultName(String consultName) {
        this.consultName = consultName == null ? null : consultName.trim();
    }

    /**
     * 咨询时间
     *
     * @mbggenerated
     */
    public Date getConsultTime() {
        return consultTime;
    }

    /**
     * 咨询时间
     *
     * @mbggenerated
     */
    public void setConsultTime(Date consultTime) {
        this.consultTime = consultTime;
    }

    /**
     * 咨询内容
     *
     * @mbggenerated
     */
    public String getConsultInfo() {
        return consultInfo;
    }

    /**
     * 咨询内容
     *
     * @mbggenerated
     */
    public void setConsultInfo(String consultInfo) {
        this.consultInfo = consultInfo == null ? null : consultInfo.trim();
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
     * 评分
     *
     * @mbggenerated
     */
    public Long getScore() {
        return score;
    }

    /**
     * 评分
     *
     * @mbggenerated
     */
    public void setScore(Long score) {
        this.score = score;
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
     * 咨询建议
     *
     * @mbggenerated
     */
    public String getConsultAdvice() {
        return consultAdvice;
    }

    /**
     * 咨询建议
     *
     * @mbggenerated
     */
    public void setConsultAdvice(String consultAdvice) {
        this.consultAdvice = consultAdvice == null ? null : consultAdvice.trim();
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
     * 服务态度
     *
     * @mbggenerated
     */
    public Long getServiceAttitude() {
        return serviceAttitude;
    }

    /**
     * 服务态度
     *
     * @mbggenerated
     */
    public void setServiceAttitude(Long serviceAttitude) {
        this.serviceAttitude = serviceAttitude;
    }

    /**
     * 服务效率
     *
     * @mbggenerated
     */
    public Long getServiceEfficiency() {
        return serviceEfficiency;
    }

    /**
     * 服务效率
     *
     * @mbggenerated
     */
    public void setServiceEfficiency(Long serviceEfficiency) {
        this.serviceEfficiency = serviceEfficiency;
    }

    /**
     * 处理结果
     *
     * @mbggenerated
     */
    public String getDealResult() {
        return dealResult;
    }

    /**
     * 处理结果
     *
     * @mbggenerated
     */
    public void setDealResult(String dealResult) {
        this.dealResult = dealResult == null ? null : dealResult.trim();
    }

    /**
     * 服务质量
     *
     * @mbggenerated
     */
    public Long getServiceQuality() {
        return serviceQuality;
    }

    /**
     * 服务质量
     *
     * @mbggenerated
     */
    public void setServiceQuality(Long serviceQuality) {
        this.serviceQuality = serviceQuality;
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