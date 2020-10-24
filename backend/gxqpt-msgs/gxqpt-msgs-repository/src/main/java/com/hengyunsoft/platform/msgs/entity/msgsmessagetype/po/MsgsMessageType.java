package com.hengyunsoft.platform.msgs.entity.msgsmessagetype.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class MsgsMessageType extends BaseEntity<Long> implements Serializable {
    /**
     * 消息类型
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 消息id
     *
     * @mbggenerated
     */
    private Long messageId;

    /**
     * 类型id
     *
     * @mbggenerated
     */
    private Long typeId;

    /**
     * 类型名称
     *
     * @mbggenerated
     */
    private String typeName;

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
     * 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 消息类型
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 消息类型
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 消息id
     *
     * @mbggenerated
     */
    public Long getMessageId() {
        return messageId;
    }

    /**
     * 消息id
     *
     * @mbggenerated
     */
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    /**
     * 类型id
     *
     * @mbggenerated
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 类型id
     *
     * @mbggenerated
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 类型名称
     *
     * @mbggenerated
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 类型名称
     *
     * @mbggenerated
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
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
     * 修改时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}