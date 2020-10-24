package com.hengyunsoft.platform.msgs.entity.bbsmsg.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class BbsIncrementReceiveMsg extends BaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 消息id
     *
     * @mbggenerated
     */
    private Long msgId;

    /**
     * 接收人id
     *
     * @mbggenerated
     */
    private Long receiveId;

    /**
     * 是否已读
     *
     * @mbggenerated
     */
    private Boolean readIs;

    /**
     * 是否需要处理
     *
     * @mbggenerated
     */
    private Boolean handlerNeedIs;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 消息id
     *
     * @mbggenerated
     */
    public Long getMsgId() {
        return msgId;
    }

    /**
     * 消息id
     *
     * @mbggenerated
     */
    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    /**
     * 接收人id
     *
     * @mbggenerated
     */
    public Long getReceiveId() {
        return receiveId;
    }

    /**
     * 接收人id
     *
     * @mbggenerated
     */
    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }

    /**
     * 是否已读
     *
     * @mbggenerated
     */
    public Boolean getReadIs() {
        return readIs;
    }

    /**
     * 是否已读
     *
     * @mbggenerated
     */
    public void setReadIs(Boolean readIs) {
        this.readIs = readIs;
    }

    /**
     * 是否需要处理
     *
     * @mbggenerated
     */
    public Boolean getHandlerNeedIs() {
        return handlerNeedIs;
    }

    /**
     * 是否需要处理
     *
     * @mbggenerated
     */
    public void setHandlerNeedIs(Boolean handlerNeedIs) {
        this.handlerNeedIs = handlerNeedIs;
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