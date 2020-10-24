package com.hengyunsoft.platform.mt.entity.feedback.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;

import java.io.Serializable;
import java.util.Date;

public class FeedBackMsg extends CommonBaseEntity<Long> implements Serializable, Comparable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 意见反馈id
     *
     * @mbggenerated
     */
    private Long fbId;

    /**
     * 消息内容
     *
     * @mbggenerated
     */
    private String msgContent;

    /**
     * 创建者姓名
     *
     * @mbggenerated
     */
    private String createUserName;

    /**
     * 是否已读(1,未读，2已读)
     *
     * @mbggenerated
     */
    private Integer isread;

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
     * 意见反馈id
     *
     * @mbggenerated
     */
    public Long getFbId() {
        return fbId;
    }

    /**
     * 意见反馈id
     *
     * @mbggenerated
     */
    public void setFbId(Long fbId) {
        this.fbId = fbId;
    }

    /**
     * 消息内容
     *
     * @mbggenerated
     */
    public String getMsgContent() {
        return msgContent;
    }

    /**
     * 消息内容
     *
     * @mbggenerated
     */
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    /**
     * 创建者姓名
     *
     * @mbggenerated
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 创建者姓名
     *
     * @mbggenerated
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 是否已读(1,未读，2已读)
     *
     * @mbggenerated
     */
    public Integer getIsread() {
        return isread;
    }

    /**
     * 是否已读(1,未读，2已读)
     *
     * @mbggenerated
     */
    public void setIsread(Integer isread) {
        this.isread = isread;
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

    @Override
    public String getAppId() {
        return null;
    }

    @Override
    public void setAppId(String appId) {

    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof FeedBackMsg) {
            FeedBackMsg th = (FeedBackMsg) o;
            if (getCreateTime().after(th.getCreateTime())) {
                return -1;
            } else if (getCreateTime().before(th.getCreateTime())) {
                return 1;
            }
            return 0;
        }
        return 1;
    }
}