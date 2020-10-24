package com.hengyunsoft.platform.search.entity.core.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class Collection extends CommonBaseEntity<Long> implements Serializable {
    @Override
    public String getAppId() {
        return getCreateAppId();
    }

    @Override
    public void setAppId(String appId) {
     setCreateAppId(appId);
    }

    @Override
    public void setCreateTime(Date nowDate) {
        setUpdateTime(nowDate);
    }

    /**
     * 集合id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 集合名词
     *
     * @mbggenerated
     */
    private String collectionName;

    /**
     * 集合编码(真正在solr的集合名词)
     *
     * @mbggenerated
     */
    private String collectionCode;

    /**
     * 创建集合的appid
     *
     * @mbggenerated
     */
    private String createAppId;

    /**
     * 创建集合的用户id
     *
     * @mbggenerated
     */
    private Long createUserId;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 集合id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 集合id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getCreateTime() {
        return null;
    }

    /**
     * 集合名词
     *
     * @mbggenerated
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * 集合名词
     *
     * @mbggenerated
     */
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName == null ? null : collectionName.trim();
    }

    /**
     * 集合编码(真正在solr的集合名词)
     *
     * @mbggenerated
     */
    public String getCollectionCode() {
        return collectionCode;
    }

    /**
     * 集合编码(真正在solr的集合名词)
     *
     * @mbggenerated
     */
    public void setCollectionCode(String collectionCode) {
        this.collectionCode = collectionCode == null ? null : collectionCode.trim();
    }

    /**
     * 创建集合的appid
     *
     * @mbggenerated
     */
    public String getCreateAppId() {
        return createAppId;
    }

    /**
     * 创建集合的appid
     *
     * @mbggenerated
     */
    public void setCreateAppId(String createAppId) {
        this.createAppId = createAppId == null ? null : createAppId.trim();
    }

    /**
     * 创建集合的用户id
     *
     * @mbggenerated
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建集合的用户id
     *
     * @mbggenerated
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}