package com.hengyunsoft.platform.warn.entity.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class WarnScaleStatistical extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * id (单位、部门、人员id)
     *
     * @mbggenerated
     */
    private String objectId;

    /**
     * 名称（部门、单位、人员名称）
     *
     * @mbggenerated
     */
    private String objectName;

    /**
     * 类型 1、单位 2、部门 3、人员
     *
     * @mbggenerated
     */
    private Integer objectType;

    /**
     * 待处理预警数量
     *
     * @mbggenerated
     */
    private Integer pendingNum;

    /**
     * 新产生预警数量
     *
     * @mbggenerated
     */
    private Integer newComeNum;

    /**
     * 已处理预警数量
     *
     * @mbggenerated
     */
    private Integer handledNum;

    /**
     * 已确认的预警数量
     *
     * @mbggenerated
     */
    private Integer confirmNum;

    /**
     * 统计预警的年月日
     *
     * @mbggenerated
     */
    private String statisticalScale;

    /**
     * 平均处理时长
     *
     * @mbggenerated
     */
    private String avgHandleTime;

    /**
     * 平均确定时长
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
     * id (单位、部门、人员id)
     *
     * @mbggenerated
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * id (单位、部门、人员id)
     *
     * @mbggenerated
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    /**
     * 名称（部门、单位、人员名称）
     *
     * @mbggenerated
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * 名称（部门、单位、人员名称）
     *
     * @mbggenerated
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName == null ? null : objectName.trim();
    }

    /**
     * 类型 1、单位 2、部门 3、人员
     *
     * @mbggenerated
     */
    public Integer getObjectType() {
        return objectType;
    }

    /**
     * 类型 1、单位 2、部门 3、人员
     *
     * @mbggenerated
     */
    public void setObjectType(Integer objectType) {
        this.objectType = objectType;
    }

    /**
     * 待处理预警数量
     *
     * @mbggenerated
     */
    public Integer getPendingNum() {
        return pendingNum;
    }

    /**
     * 待处理预警数量
     *
     * @mbggenerated
     */
    public void setPendingNum(Integer pendingNum) {
        this.pendingNum = pendingNum;
    }

    /**
     * 新产生预警数量
     *
     * @mbggenerated
     */
    public Integer getNewComeNum() {
        return newComeNum;
    }

    /**
     * 新产生预警数量
     *
     * @mbggenerated
     */
    public void setNewComeNum(Integer newComeNum) {
        this.newComeNum = newComeNum;
    }

    /**
     * 已处理预警数量
     *
     * @mbggenerated
     */
    public Integer getHandledNum() {
        return handledNum;
    }

    /**
     * 已处理预警数量
     *
     * @mbggenerated
     */
    public void setHandledNum(Integer handledNum) {
        this.handledNum = handledNum;
    }

    /**
     * 统计预警的年月日
     *
     * @mbggenerated
     */
    public String getStatisticalScale() {
        return statisticalScale;
    }

    /**
     * 统计预警的年月日
     *
     * @mbggenerated
     */
    public void setStatisticalScale(String statisticalScale) {
        this.statisticalScale = statisticalScale == null ? null : statisticalScale.trim();
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
     * 平均确定时长
     *
     * @mbggenerated
     */
    public String getAvgConfirmTime() {
        return avgConfirmTime;
    }

    /**
     * 平均确定时长
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

    public Integer getConfirmNum() {
        return confirmNum;
    }

    public void setConfirmNum(Integer confirmNum) {
        this.confirmNum = confirmNum;
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