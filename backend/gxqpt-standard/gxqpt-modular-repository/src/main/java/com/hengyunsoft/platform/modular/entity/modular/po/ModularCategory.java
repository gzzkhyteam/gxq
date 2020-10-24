package com.hengyunsoft.platform.modular.entity.modular.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ModularCategory extends BaseEntity<Long> implements Serializable {
    /**
     * id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 模块id
     *
     * @mbggenerated
     */
    private Long modularId;

    /**
     * 类别id
     *
     * @mbggenerated
     */
    private Long categoryId;

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
     * 类别id
     *
     * @mbggenerated
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 类别id
     *
     * @mbggenerated
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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