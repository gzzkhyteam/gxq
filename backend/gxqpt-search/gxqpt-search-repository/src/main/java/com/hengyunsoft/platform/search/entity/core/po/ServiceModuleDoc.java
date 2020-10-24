package com.hengyunsoft.platform.search.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class ServiceModuleDoc extends BaseEntity<Long> implements Serializable {
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 模块id
     *
     * @mbggenerated
     */
    @FieldDesc("模块id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long moduleId;

    /**
     * 序号
     *
     * @mbggenerated
     */
    @FieldDesc("序号")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer order;

    /**
     * 标题
     *
     * @mbggenerated
     */
    @FieldDesc("标题")
    @Length(max=50)
    private String title;

    /**
     * 发布状态： 未发布、已发表
     *
     * @mbggenerated
     */
    @FieldDesc("发布状态： 未发布、已发表")
    private Boolean publishStatus;

    /**
     * 内容
     *
     * @mbggenerated
     */
    @FieldDesc("内容")
    @Length(max=65535)
    private String content;

    /**
     * 是否公有资源（是否需要登陆方可查看）
     *
     * @mbggenerated
     */
    @FieldDesc("是否公有资源（是否需要登陆方可查看）")
    private Boolean publicIs;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    @FieldDesc("创建人id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    @FieldDesc("更新人id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    private Date updateTime;

    /**
     * json格式字符串
     *
     * @mbggenerated
     */
    @FieldDesc("json格式字符串")
    @Length(max=2147483647)
    private String jsonContent;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 模块id
     *
     * @mbggenerated
     */
    public Long getModuleId() {
        return moduleId;
    }

    /**
     * 模块id
     *
     * @mbggenerated
     */
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * 序号
     *
     * @mbggenerated
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 序号
     *
     * @mbggenerated
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * 标题
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 发布状态： 未发布、已发表
     *
     * @mbggenerated
     */
    public Boolean getPublishStatus() {
        return publishStatus;
    }

    /**
     * 发布状态： 未发布、已发表
     *
     * @mbggenerated
     */
    public void setPublishStatus(Boolean publishStatus) {
        this.publishStatus = publishStatus;
    }

    /**
     * 内容
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 是否公有资源（是否需要登陆方可查看）
     *
     * @mbggenerated
     */
    public Boolean getPublicIs() {
        return publicIs;
    }

    /**
     * 是否公有资源（是否需要登陆方可查看）
     *
     * @mbggenerated
     */
    public void setPublicIs(Boolean publicIs) {
        this.publicIs = publicIs;
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
     * 更新人id
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人id
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

    /**
     * json格式字符串
     *
     * @mbggenerated
     */
    public String getJsonContent() {
        return jsonContent;
    }

    /**
     * json格式字符串
     *
     * @mbggenerated
     */
    public void setJsonContent(String jsonContent) {
        this.jsonContent = jsonContent == null ? null : jsonContent.trim();
    }
}