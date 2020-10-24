package com.hengyunsoft.platform.developer.entity.fast.po.attence;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class WorkApproveExtra extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 审批主键
     *
     * @mbggenerated
     */
    private Long approveId;

    /**
     * 加班开始日期
     *
     * @mbggenerated
     */
    private Date startTime;

    /**
     * 加班结束日期
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     * 加班时间长（小时）
     *
     * @mbggenerated
     */
    private Float extraHour;

    /**
     * 加班内容
     *
     * @mbggenerated
     */
    private String content;

    private String imgUrl;

    /**
     * '是否自动扫描到考勤统计的加班小时（1：是，2：否）'
     *
     * @mbggenerated
     */
    private Short autoUpdate;

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
     * 审批主键
     *
     * @mbggenerated
     */
    public Long getApproveId() {
        return approveId;
    }

    /**
     * 审批主键
     *
     * @mbggenerated
     */
    public void setApproveId(Long approveId) {
        this.approveId = approveId;
    }

    /**
     * 加班开始日期
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 加班开始日期
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 加班结束日期
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 加班结束日期
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 加班时间长（小时）
     *
     * @mbggenerated
     */
    public Float getExtraHour() {
        return extraHour;
    }

    /**
     * 加班时间长（小时）
     *
     * @mbggenerated
     */
    public void setExtraHour(Float extraHour) {
        this.extraHour = extraHour;
    }

    /**
     * 加班内容
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 加班内容
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * '是否自动扫描到考勤统计的加班小时（1：是，2：否）'
     *
     * @mbggenerated
     */
    public Short getAutoUpdate() {
        return autoUpdate;
    }

    /**
     * '是否自动扫描到考勤统计的加班小时（1：是，2：否）'
     *
     * @mbggenerated
     */
    public void setAutoUpdate(Short autoUpdate) {
        this.autoUpdate = autoUpdate;
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