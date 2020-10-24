package com.hengyunsoft.platform.mt.entity.help.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.FieldDesc;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class UseTheHelp extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    @FieldDesc("主键id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=ValidatorGroups.MustNoneNull.class)
    private Long id;

    /**
     * 标题
     *
     * @mbggenerated
     */
    @FieldDesc("标题")
    @Length(max=255)
    private String title;

    /**
     * 内容
     *
     * @mbggenerated
     */
    @FieldDesc("内容")
    @Length(max=65535)
    private String content;

    /**
     * 模块id
     *
     * @mbggenerated
     */
    @FieldDesc("模块id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long modularId;

    /**
     * 审核状态；1：未审核,2：审核通过
     *
     * @mbggenerated
     */
    @FieldDesc("审核状态；1：未审核,2：审核通过")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer status;

    /**
     * 常用标准；1：Yes,2：NO
     *
     * @mbggenerated
     */
    @FieldDesc("常用标准；1：Yes,2：NO")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer commonlyMark;

    /**
     * 审核人
     *
     * @mbggenerated
     */
    @FieldDesc("审核人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long auditor;

    /**
     * 审核时间
     *
     * @mbggenerated
     */
    @FieldDesc("审核时间")
    private Date auditorTime;

    /**
     * 审核意见
     *
     * @mbggenerated
     */
    @FieldDesc("审核意见")
    @Length(max=64)
    private String auditOpinion;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @FieldDesc("创建人")
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
     * 更新人
     *
     * @mbggenerated
     */
    @FieldDesc("更新人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    private Date updateTime;

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
     * 模块id
     *
     * @mbggenerated
     */
    public Long getModularId() {
        return modularId;
    }

    /**
     * 模块id
     *
     * @mbggenerated
     */
    public void setModularId(Long modularId) {
        this.modularId = modularId;
    }

    /**
     * 审核状态；1：未审核,2：审核通过
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 审核状态；1：未审核,2：审核通过
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 常用标准；1：Yes,2：NO
     *
     * @mbggenerated
     */
    public Integer getCommonlyMark() {
        return commonlyMark;
    }

    /**
     * 常用标准；1：Yes,2：NO
     *
     * @mbggenerated
     */
    public void setCommonlyMark(Integer commonlyMark) {
        this.commonlyMark = commonlyMark;
    }

    /**
     * 审核人
     *
     * @mbggenerated
     */
    public Long getAuditor() {
        return auditor;
    }

    /**
     * 审核人
     *
     * @mbggenerated
     */
    public void setAuditor(Long auditor) {
        this.auditor = auditor;
    }

    /**
     * 审核时间
     *
     * @mbggenerated
     */
    public Date getAuditorTime() {
        return auditorTime;
    }

    /**
     * 审核时间
     *
     * @mbggenerated
     */
    public void setAuditorTime(Date auditorTime) {
        this.auditorTime = auditorTime;
    }

    /**
     * 审核意见
     *
     * @mbggenerated
     */
    public String getAuditOpinion() {
        return auditOpinion;
    }

    /**
     * 审核意见
     *
     * @mbggenerated
     */
    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion == null ? null : auditOpinion.trim();
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