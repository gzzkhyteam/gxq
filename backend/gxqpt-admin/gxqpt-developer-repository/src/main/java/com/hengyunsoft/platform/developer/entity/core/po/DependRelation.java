package com.hengyunsoft.platform.developer.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class DependRelation extends BaseEntity<Long> implements Serializable {
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 消费方类型   app 应用
     *
     * @mbggenerated
     */
    @FieldDesc("消费方类型   app 应用")
    @Length(max=8)
    private String consumeType;

    /**
     * 调用方id   应用id
     *
     * @mbggenerated
     */
    @FieldDesc("调用方id   应用id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long consumeId;

    /**
     * app提供方是应用   service服务功能    module 模块  
     *
     * @mbggenerated
     */
    @FieldDesc("app提供方是应用   service服务功能    module 模块")
    @Length(max=8)
    private String producerType;

    /**
     * 模块id   服务id  应用id
     *
     * @mbggenerated
     */
    @FieldDesc("模块id   服务id  应用id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long producerId;

    /**
     * 生产者（提供方）名称 比如模块名称   服务名称等等
     *
     * @mbggenerated
     */
    @FieldDesc("生产者（提供方）名称 比如模块名称   服务名称等等")
    @Length(max=60)
    private String producerName;

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
     * 使用此应用，可以节省多少工期（人/天）
     *
     * @mbggenerated
     */
    @FieldDesc("使用此应用，可以节省多少工期（人/天）")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Double reduceTime;

    /**
     * 使用此应用，可以节省多少前（元）
     *
     * @mbggenerated
     */
    @FieldDesc("使用此应用，可以节省多少前（元）")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer reduceCost;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 消费方类型   app 应用
     *
     * @mbggenerated
     */
    public String getConsumeType() {
        return consumeType;
    }

    /**
     * 消费方类型   app 应用
     *
     * @mbggenerated
     */
    public void setConsumeType(String consumeType) {
        this.consumeType = consumeType == null ? null : consumeType.trim();
    }

    /**
     * 调用方id   应用id
     *
     * @mbggenerated
     */
    public Long getConsumeId() {
        return consumeId;
    }

    /**
     * 调用方id   应用id
     *
     * @mbggenerated
     */
    public void setConsumeId(Long consumeId) {
        this.consumeId = consumeId;
    }

    /**
     * app提供方是应用   service服务功能    module 模块  
     *
     * @mbggenerated
     */
    public String getProducerType() {
        return producerType;
    }

    /**
     * app提供方是应用   service服务功能    module 模块  
     *
     * @mbggenerated
     */
    public void setProducerType(String producerType) {
        this.producerType = producerType == null ? null : producerType.trim();
    }

    /**
     * 模块id   服务id  应用id
     *
     * @mbggenerated
     */
    public Long getProducerId() {
        return producerId;
    }

    /**
     * 模块id   服务id  应用id
     *
     * @mbggenerated
     */
    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    /**
     * 生产者（提供方）名称 比如模块名称   服务名称等等
     *
     * @mbggenerated
     */
    public String getProducerName() {
        return producerName;
    }

    /**
     * 生产者（提供方）名称 比如模块名称   服务名称等等
     *
     * @mbggenerated
     */
    public void setProducerName(String producerName) {
        this.producerName = producerName == null ? null : producerName.trim();
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
     * 使用此应用，可以节省多少工期（人/天）
     *
     * @mbggenerated
     */
    public Double getReduceTime() {
        return reduceTime;
    }

    /**
     * 使用此应用，可以节省多少工期（人/天）
     *
     * @mbggenerated
     */
    public void setReduceTime(Double reduceTime) {
        this.reduceTime = reduceTime;
    }

    /**
     * 使用此应用，可以节省多少前（元）
     *
     * @mbggenerated
     */
    public Integer getReduceCost() {
        return reduceCost;
    }

    /**
     * 使用此应用，可以节省多少前（元）
     *
     * @mbggenerated
     */
    public void setReduceCost(Integer reduceCost) {
        this.reduceCost = reduceCost;
    }
}