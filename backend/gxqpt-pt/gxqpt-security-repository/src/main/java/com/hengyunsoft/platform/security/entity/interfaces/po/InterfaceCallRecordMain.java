package com.hengyunsoft.platform.security.entity.interfaces.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class InterfaceCallRecordMain extends BaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 账号
     *
     * @mbggenerated
     */
    private String account;

    private String userName;

    /**
     * 接口名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 调用时间
     *
     * @mbggenerated
     */
    private Date createTime;
    
    private String consumerAppId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 账号
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * 账号
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 接口名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 接口名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 调用时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 调用时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getConsumerAppId() {
		return consumerAppId;
	}

	public void setConsumerAppId(String consumerAppId) {
		this.consumerAppId = consumerAppId;
	}
    
    
}