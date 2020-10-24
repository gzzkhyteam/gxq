package com.hengyunsoft.platform.ops.entity.person.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class PersonManage extends BaseEntity<Long> implements Serializable {
    /**
     * 用户id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 电话
     *
     * @mbggenerated
     */
    private String mainmobile;

    /**
     * 主要工作内容
     *
     * @mbggenerated
     */
    private String content;

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
     * 用户id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 用户id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 电话
     *
     * @mbggenerated
     */
    public String getMainmobile() {
        return mainmobile;
    }

    /**
     * 电话
     *
     * @mbggenerated
     */
    public void setMainmobile(String mainmobile) {
        this.mainmobile = mainmobile == null ? null : mainmobile.trim();
    }

    /**
     * 主要工作内容
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 主要工作内容
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
}