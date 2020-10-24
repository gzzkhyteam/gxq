package com.hengyunsoft.platform.warn.entity.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class GxqptSendStatus extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 预警id
     *
     * @mbggenerated
     */
    private Long warnId;

    /**
     * 发送状态
     *
     * @mbggenerated
     */
    private Integer sendStatus;

    /**
     * 结果描述
     *
     * @mbggenerated
     */
    private String result;

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
     * 预警id
     *
     * @mbggenerated
     */
    public Long getWarnId() {
        return warnId;
    }

    /**
     * 预警id
     *
     * @mbggenerated
     */
    public void setWarnId(Long warnId) {
        this.warnId = warnId;
    }

    /**
     * 发送状态
     *
     * @mbggenerated
     */
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
     * 发送状态
     *
     * @mbggenerated
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    /**
     * 结果描述
     *
     * @mbggenerated
     */
    public String getResult() {
        return result;
    }

    /**
     * 结果描述
     *
     * @mbggenerated
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}