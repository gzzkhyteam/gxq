package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class SmsTemplate extends BaseEntity<Long> implements Serializable {
    /**
     * 模板id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 渠道id
     *
     * @mbggenerated
     */
    private String channelId;

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 应用程序名称
     *
     * @mbggenerated
     */
    private String appName;

    /**
     * 模板名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 模板类型
     *
     * @mbggenerated
     */
    private String type;

    /**
     * 模板内容
     *
     * @mbggenerated
     */
    private String content;

    /**
     * 模板创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 模板更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 模板参数
     *
     * @mbggenerated
     */
    private String templateParam;

    /**
     * 模板code
     *
     * @mbggenerated
     */
    private String templateCode;

    /**
     * 模板签名名称
     *
     * @mbggenerated
     */
    private String signName;

    /**
     * 模板描述
     *
     * @mbggenerated
     */
    private String templateDescribe;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 创建人名称
     *
     * @mbggenerated
     */
    private String createUserName;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private String updateUser;

    private static final long serialVersionUID = 1L;

    /**
     * 模板id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 模板id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 渠道id
     *
     * @mbggenerated
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 渠道id
     *
     * @mbggenerated
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 应用程序名称
     *
     * @mbggenerated
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 应用程序名称
     *
     * @mbggenerated
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 模板名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 模板名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 模板类型
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 模板类型
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 模板内容
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 模板内容
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 模板创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 模板创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 模板更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 模板更新时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 模板参数
     *
     * @mbggenerated
     */
    public String getTemplateParam() {
        return templateParam;
    }

    /**
     * 模板参数
     *
     * @mbggenerated
     */
    public void setTemplateParam(String templateParam) {
        this.templateParam = templateParam == null ? null : templateParam.trim();
    }

    /**
     * 模板code
     *
     * @mbggenerated
     */
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * 模板code
     *
     * @mbggenerated
     */
    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode == null ? null : templateCode.trim();
    }

    /**
     * 模板签名名称
     *
     * @mbggenerated
     */
    public String getSignName() {
        return signName;
    }

    /**
     * 模板签名名称
     *
     * @mbggenerated
     */
    public void setSignName(String signName) {
        this.signName = signName == null ? null : signName.trim();
    }

    /**
     * 模板描述
     *
     * @mbggenerated
     */
    public String getTemplateDescribe() {
        return templateDescribe;
    }

    /**
     * 模板描述
     *
     * @mbggenerated
     */
    public void setTemplateDescribe(String templateDescribe) {
        this.templateDescribe = templateDescribe == null ? null : templateDescribe.trim();
    }

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 创建人名称
     *
     * @mbggenerated
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 创建人名称
     *
     * @mbggenerated
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }
}