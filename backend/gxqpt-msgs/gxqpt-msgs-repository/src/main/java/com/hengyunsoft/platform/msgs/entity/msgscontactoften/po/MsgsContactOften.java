package com.hengyunsoft.platform.msgs.entity.msgscontactoften.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class MsgsContactOften extends BaseEntity<Long> implements Serializable {
    private Long id;

    private Long userId;

    /**
     * 电话号码
     *
     * @mbggenerated
     */
    private String contact;

    /**
     * 使用次数
     *
     * @mbggenerated
     */
    private Integer useNum;

    private Date createTime;

    private Long createUser;

    private Date updateTime;

    private Long updateUser;

    private String contactname;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 电话号码
     *
     * @mbggenerated
     */
    public String getContact() {
        return contact;
    }

    /**
     * 电话号码
     *
     * @mbggenerated
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * 使用次数
     *
     * @mbggenerated
     */
    public Integer getUseNum() {
        return useNum;
    }

    /**
     * 使用次数
     *
     * @mbggenerated
     */
    public void setUseNum(Integer useNum) {
        this.useNum = useNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname == null ? null : contactname.trim();
    }
}