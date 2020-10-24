package com.hengyunsoft.platform.warn.entity.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class WarnTimeSlot extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 应用程序名称
     *
     * @mbggenerated
     */
    private String appName;

    /**
     * 待处理预警数量
     *
     * @mbggenerated
     */
    private Integer pending;

    /**
     * 新产生预警数量
     *
     * @mbggenerated
     */
    private Integer newCome;

    /**
     * 已处理预警数量
     *
     * @mbggenerated
     */
    private Integer handled;

    /**
     * 已确认预警数量
     *
     * @mbggenerated
     */
    private Integer confirm;

    /**
     * 未确认预警数量
     *
     * @mbggenerated
     */
    private Integer unconfirm;

    /**
     * 统计预警的年月份
     *
     * @mbggenerated
     */
    private String statisticalTime;

    /**
     * 平均处理时长
     *
     * @mbggenerated
     */
    private String avgHandleTime;

    /**
     * 平局确认时长
     *
     * @mbggenerated
     */
    private String avgConfirmTime;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 应用程序名称
     *
     * @mbggenerated
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 应用程序名称
     *
     * @mbggenerated
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 待处理预警数量
     *
     * @mbggenerated
     */
    public Integer getPending() {
        return pending;
    }

    /**
     * 待处理预警数量
     *
     * @mbggenerated
     */
    public void setPending(Integer pending) {
        this.pending = pending;
    }

    /**
     * 新产生预警数量
     *
     * @mbggenerated
     */
    public Integer getNewCome() {
        return newCome;
    }

    /**
     * 新产生预警数量
     *
     * @mbggenerated
     */
    public void setNewCome(Integer newCome) {
        this.newCome = newCome;
    }

    /**
     * 已处理预警数量
     *
     * @mbggenerated
     */
    public Integer getHandled() {
        return handled;
    }

    /**
     * 已处理预警数量
     *
     * @mbggenerated
     */
    public void setHandled(Integer handled) {
        this.handled = handled;
    }

    /**
     * 统计预警的年月份
     *
     * @mbggenerated
     */
    public String getStatisticalTime() {
        return statisticalTime;
    }

    /**
     * 统计预警的年月份
     *
     * @mbggenerated
     */
    public void setStatisticalTime(String statisticalTime) {
        this.statisticalTime = statisticalTime == null ? null : statisticalTime.trim();
    }

    /**
     * 平均处理时长
     *
     * @mbggenerated
     */
    public String getAvgHandleTime() {
        return avgHandleTime;
    }

    /**
     * 平均处理时长
     *
     * @mbggenerated
     */
    public void setAvgHandleTime(String avgHandleTime) {
        this.avgHandleTime = avgHandleTime == null ? null : avgHandleTime.trim();
    }

    /**
     * 平局确认时长
     *
     * @mbggenerated
     */
    public String getAvgConfirmTime() {
        return avgConfirmTime;
    }

    /**
     * 平局确认时长
     *
     * @mbggenerated
     */
    public void setAvgConfirmTime(String avgConfirmTime) {
        this.avgConfirmTime = avgConfirmTime == null ? null : avgConfirmTime.trim();
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    public Integer getConfirm() {
        return confirm;
    }

    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

    public Integer getUnconfirm() {
        return unconfirm;
    }

    public void setUnconfirm(Integer unconfirm) {
        this.unconfirm = unconfirm;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getUpdateTime() {
        return null;
    }

    @Override
    public void setUpdateTime(Date arg0) {

    }

}