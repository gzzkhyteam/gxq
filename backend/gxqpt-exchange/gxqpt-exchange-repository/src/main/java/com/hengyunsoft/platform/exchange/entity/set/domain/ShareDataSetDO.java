package com.hengyunsoft.platform.exchange.entity.set.domain;

import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSet;

import java.util.Date;

public class ShareDataSetDO extends ShareDataSet {
    /***
     * 流程任务id
     */
    private Long taskId;
    /***
     * 数据集id
     */
    private Long id;
    /***
     *创建人
     */
    private String createUserName;
    /***
     * 关联数据集数量
     */
    private Integer relatedDicCunt;
    /***
     * 当前流程编码
     */
    private String applyCode;
    /**
     * 1：新增，2修改
     */
    private int applyType;
    /***
     * 是否可以删除
     */
    private int canDelete;
    /***
     * 申请时间
     */
    private Date applyTime;
    /***
     * 处理意见
     */
    private String dealContext;
    /***
     * 创建时间
     */
    private Date createTime;

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Integer getRelatedDicCunt() {
        return relatedDicCunt;
    }

    public void setRelatedDicCunt(Integer relatedDicCunt) {
        this.relatedDicCunt = relatedDicCunt;
    }

    @Override
    public String getApplyCode() {
        return applyCode;
    }

    @Override
    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }

    public int getApplyType() {
        return applyType;
    }

    public void setApplyType(int applyType) {
        this.applyType = applyType;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public int getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(int canDelete) {
        this.canDelete = canDelete;
    }

    public String getDealContext() {
        return dealContext;
    }

    public void setDealContext(String dealContext) {
        this.dealContext = dealContext;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
