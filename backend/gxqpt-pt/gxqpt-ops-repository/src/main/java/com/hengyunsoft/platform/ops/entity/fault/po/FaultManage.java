package com.hengyunsoft.platform.ops.entity.fault.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class FaultManage extends BaseEntity<Long> implements Serializable {
    /**
     * id
     *
     * @mbggenerated
     */
    private Long id;

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

    /**
     * 故障名称
     *
     * @mbggenerated
     */
    private String faultName;

    /**
     * 故障类别
     *
     * @mbggenerated
     */
    private String faultType;

    /**
     * 故障级别
     *
     * @mbggenerated
     */
    private String faultLevel;

    /**
     * 系统id
     *
     * @mbggenerated
     */
    private String systemId;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    private String systemName;

    /**
     * 故障主机
     *
     * @mbggenerated
     */
    private String faultHost;

    /**
     * 状态:1未处理2c处理中3已完结
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 产生时间
     *
     * @mbggenerated
     */
    private Date happenTime;

    /**
     * 故障简述
     *
     * @mbggenerated
     */
    private String faultInfo;

    /**
     * 是否属实
     *
     * @mbggenerated
     */
    private String isTrue;

    /**
     * 处理意见
     *
     * @mbggenerated
     */
    private String dealOpinion;

    /**
     * 处理时间
     *
     * @mbggenerated
     */
    private Date dealTime;

    /**
     * 处理流程
     *
     * @mbggenerated
     */
    private String dealProcess;

    /**
     * 处理结果
     *
     * @mbggenerated
     */
    private String result;

    /**
     * 建议
     *
     * @mbggenerated
     */
    private String advice;

    /**
     * 是否加入知识库
     *
     * @mbggenerated
     */
    private Integer isJoinKnowledge;

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

    /**
     * 故障名称
     *
     * @mbggenerated
     */
    public String getFaultName() {
        return faultName;
    }

    /**
     * 故障名称
     *
     * @mbggenerated
     */
    public void setFaultName(String faultName) {
        this.faultName = faultName == null ? null : faultName.trim();
    }

    /**
     * 故障类别
     *
     * @mbggenerated
     */
    public String getFaultType() {
        return faultType;
    }

    /**
     * 故障类别
     *
     * @mbggenerated
     */
    public void setFaultType(String faultType) {
        this.faultType = faultType == null ? null : faultType.trim();
    }

    /**
     * 故障级别
     *
     * @mbggenerated
     */
    public String getFaultLevel() {
        return faultLevel;
    }

    /**
     * 故障级别
     *
     * @mbggenerated
     */
    public void setFaultLevel(String faultLevel) {
        this.faultLevel = faultLevel == null ? null : faultLevel.trim();
    }

    /**
     * 系统id
     *
     * @mbggenerated
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * 系统id
     *
     * @mbggenerated
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    /**
     * 故障主机
     *
     * @mbggenerated
     */
    public String getFaultHost() {
        return faultHost;
    }

    /**
     * 故障主机
     *
     * @mbggenerated
     */
    public void setFaultHost(String faultHost) {
        this.faultHost = faultHost == null ? null : faultHost.trim();
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
     * 产生时间
     *
     * @mbggenerated
     */
    public Date getHappenTime() {
        return happenTime;
    }

    /**
     * 产生时间
     *
     * @mbggenerated
     */
    public void setHappenTime(Date happenTime) {
        this.happenTime = happenTime;
    }

    /**
     * 故障简述
     *
     * @mbggenerated
     */
    public String getFaultInfo() {
        return faultInfo;
    }

    /**
     * 故障简述
     *
     * @mbggenerated
     */
    public void setFaultInfo(String faultInfo) {
        this.faultInfo = faultInfo == null ? null : faultInfo.trim();
    }

    /**
     * 是否属实
     *
     * @mbggenerated
     */
    public String getIsTrue() {
        return isTrue;
    }

    /**
     * 是否属实
     *
     * @mbggenerated
     */
    public void setIsTrue(String isTrue) {
        this.isTrue = isTrue == null ? null : isTrue.trim();
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
     * 处理时间
     *
     * @mbggenerated
     */
    public Date getDealTime() {
        return dealTime;
    }

    /**
     * 处理时间
     *
     * @mbggenerated
     */
    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    /**
     * 处理流程
     *
     * @mbggenerated
     */
    public String getDealProcess() {
        return dealProcess;
    }

    /**
     * 处理流程
     *
     * @mbggenerated
     */
    public void setDealProcess(String dealProcess) {
        this.dealProcess = dealProcess == null ? null : dealProcess.trim();
    }

    /**
     * 处理结果
     *
     * @mbggenerated
     */
    public String getResult() {
        return result;
    }

    /**
     * 处理结果
     *
     * @mbggenerated
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * 建议
     *
     * @mbggenerated
     */
    public String getAdvice() {
        return advice;
    }

    /**
     * 建议
     *
     * @mbggenerated
     */
    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    /**
     * 是否加入知识库
     *
     * @mbggenerated
     */
    public Integer getIsJoinKnowledge() {
        return isJoinKnowledge;
    }

    /**
     * 是否加入知识库
     *
     * @mbggenerated
     */
    public void setIsJoinKnowledge(Integer isJoinKnowledge) {
        this.isJoinKnowledge = isJoinKnowledge;
    }
}