package com.hengyunsoft.platform.sms.entity.template.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class SmsTemplate extends BaseEntity<Long> implements Serializable {
    /**
     * 模板id
     *
     * @mbggenerated
     */
    @FieldDesc("模板id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 渠道id
     *
     * @mbggenerated
     */
    @FieldDesc("渠道id")
    @Length(max=64)
    @NotNull(groups=MustNoneNull.class)
    private String channelId;

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    @FieldDesc("应用程序id")
    @Length(max=100)
    private String appId;

    /**
     * 应用程序名称
     *
     * @mbggenerated
     */
    @FieldDesc("应用程序名称")
    @Length(max=100)
    private String appName;

    /**
     * 模板名称
     *
     * @mbggenerated
     */
    @FieldDesc("模板名称")
    @Length(max=100)
    private String name;

    /**
     * 模板类型
     *
     * @mbggenerated
     */
    @FieldDesc("模板类型")
    @Length(max=20)
    private String type;

    /**
     * 模板内容
     *
     * @mbggenerated
     */
    @FieldDesc("模板内容")
    @Length(max=255)
    @NotNull(groups=MustNoneNull.class)
    private String content;

    /**
     * 模板创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("模板创建时间")
    @NotNull(groups=MustNoneNull.class)
    private Date createTime;

    /**
     * 模板更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("模板更新时间")
    private Date updateTime;

    /**
     * 模板参数
     *
     * @mbggenerated
     */
    @FieldDesc("模板参数")
    @Length(max=255)
    @NotNull(groups=MustNoneNull.class)
    private String templateParam;

    /**
     * 模板code
     *
     * @mbggenerated
     */
    @FieldDesc("模板code")
    @Length(max=50)
    private String templateCode;

    /**
     * 模板签名名称
     *
     * @mbggenerated
     */
    @FieldDesc("模板签名名称")
    @Length(max=100)
    private String signName;

    /**
     * 模板描述
     *
     * @mbggenerated
     */
    @FieldDesc("模板描述")
    @Length(max=255)
    private String templateDescribe;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    @FieldDesc("创建人id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    /**
     * 创建人名称
     *
     * @mbggenerated
     */
    @FieldDesc("创建人名称")
    @Length(max=100)
    private String createUserName;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @FieldDesc("更新人")
    @Length(max=100)
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