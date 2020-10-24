package com.hengyunsoft.platform.modular.entity.modular.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ModularCategoryDef extends BaseEntity<Long> implements Serializable {
    /**
     * id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 模块分类名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 模块分类描述
     *
     * @mbggenerated
     */
    private String description;

    /**
     * 上传时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 模块分类名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 模块分类名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 模块分类描述
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * 模块分类描述
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 上传时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 上传时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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