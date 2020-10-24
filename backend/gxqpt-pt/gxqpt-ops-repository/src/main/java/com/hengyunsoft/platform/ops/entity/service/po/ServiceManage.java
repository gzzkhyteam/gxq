package com.hengyunsoft.platform.ops.entity.service.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ServiceManage extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 服务类别
     *
     * @mbggenerated
     */
    private String serviceType;

    /**
     * 服务对象
     *
     * @mbggenerated
     */
    private String serviceObj;

    /**
     * 服务分类
     *
     * @mbggenerated
     */
    private String serviceClass;

    /**
     * 服务名称
     *
     * @mbggenerated
     */
    private String serviceName;

    /**
     * 服务开始时间
     *
     * @mbggenerated
     */
    private Date startTime;

    /**
     * 服务结束时间
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     * 报告结束时间
     *
     * @mbggenerated
     */
    private Date reportTime;

    /**
     * 服务过程
     *
     * @mbggenerated
     */
    private String serviceProcess;

    /**
     * 结果
     *
     * @mbggenerated
     */
    private String result;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * 申请人
     *
     * @mbggenerated
     */
    private String applyUser;

    /**
     * 申请单位
     *
     * @mbggenerated
     */
    private String applyOrg;

    /**
     * 审批意见
     *
     * @mbggenerated
     */
    private String auditOpinion;

    /**
     * 状态:1未处理，2已驳回,3已同意4已完结
     *
     * @mbggenerated
     */
    private Integer status;

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
     * 服务评价
     *
     * @mbggenerated
     */
    private Long serviceEvaluation;

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
     * 服务建议
     *
     * @mbggenerated
     */
    private String serviceAdvice;

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    private String applyCode;

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
     * 服务类别
     *
     * @mbggenerated
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * 服务类别
     *
     * @mbggenerated
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    /**
     * 服务对象
     *
     * @mbggenerated
     */
    public String getServiceObj() {
        return serviceObj;
    }

    /**
     * 服务对象
     *
     * @mbggenerated
     */
    public void setServiceObj(String serviceObj) {
        this.serviceObj = serviceObj == null ? null : serviceObj.trim();
    }

    /**
     * 服务分类
     *
     * @mbggenerated
     */
    public String getServiceClass() {
        return serviceClass;
    }

    /**
     * 服务分类
     *
     * @mbggenerated
     */
    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass == null ? null : serviceClass.trim();
    }

    /**
     * 服务名称
     *
     * @mbggenerated
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * 服务名称
     *
     * @mbggenerated
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    /**
     * 服务开始时间
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 服务开始时间
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 服务结束时间
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 服务结束时间
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 报告结束时间
     *
     * @mbggenerated
     */
    public Date getReportTime() {
        return reportTime;
    }

    /**
     * 报告结束时间
     *
     * @mbggenerated
     */
    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    /**
     * 服务过程
     *
     * @mbggenerated
     */
    public String getServiceProcess() {
        return serviceProcess;
    }

    /**
     * 服务过程
     *
     * @mbggenerated
     */
    public void setServiceProcess(String serviceProcess) {
        this.serviceProcess = serviceProcess == null ? null : serviceProcess.trim();
    }

    /**
     * 结果
     *
     * @mbggenerated
     */
    public String getResult() {
        return result;
    }

    /**
     * 结果
     *
     * @mbggenerated
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 申请人
     *
     * @mbggenerated
     */
    public String getApplyUser() {
        return applyUser;
    }

    /**
     * 申请人
     *
     * @mbggenerated
     */
    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser == null ? null : applyUser.trim();
    }

    /**
     * 申请单位
     *
     * @mbggenerated
     */
    public String getApplyOrg() {
        return applyOrg;
    }

    /**
     * 申请单位
     *
     * @mbggenerated
     */
    public void setApplyOrg(String applyOrg) {
        this.applyOrg = applyOrg == null ? null : applyOrg.trim();
    }

    /**
     * 审批意见
     *
     * @mbggenerated
     */
    public String getAuditOpinion() {
        return auditOpinion;
    }

    /**
     * 审批意见
     *
     * @mbggenerated
     */
    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion == null ? null : auditOpinion.trim();
    }

    /**
     * 状态:1未处理，2已驳回,3已同意4已完结
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态:1未处理，2已驳回,3已同意4已完结
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * 服务评价
     *
     * @mbggenerated
     */
    public Long getServiceEvaluation() {
        return serviceEvaluation;
    }

    /**
     * 服务评价
     *
     * @mbggenerated
     */
    public void setServiceEvaluation(Long serviceEvaluation) {
        this.serviceEvaluation = serviceEvaluation;
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
     * 服务建议
     *
     * @mbggenerated
     */
    public String getServiceAdvice() {
        return serviceAdvice;
    }

    /**
     * 服务建议
     *
     * @mbggenerated
     */
    public void setServiceAdvice(String serviceAdvice) {
        this.serviceAdvice = serviceAdvice == null ? null : serviceAdvice.trim();
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