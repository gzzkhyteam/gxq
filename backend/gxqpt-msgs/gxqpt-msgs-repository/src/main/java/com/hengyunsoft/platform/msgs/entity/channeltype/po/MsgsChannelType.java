package com.hengyunsoft.platform.msgs.entity.channeltype.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class MsgsChannelType extends BaseEntity<Long> implements Serializable {
    /**
     * 渠道类型
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 厂商名称
     *
     * @mbggenerated
     */
    private String factoryName;

    /**
     * 支持消息类型
     *
     * @mbggenerated
     */
    private String msgType;

    /**
     * 说明
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    private Long createUser;

    private Long updateUser;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 渠道类型
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 渠道类型
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 厂商名称
     *
     * @mbggenerated
     */
    public String getFactoryName() {
        return factoryName;
    }

    /**
     * 厂商名称
     *
     * @mbggenerated
     */
    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    /**
     * 支持消息类型
     *
     * @mbggenerated
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * 支持消息类型
     *
     * @mbggenerated
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    /**
     * 说明
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 说明
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}