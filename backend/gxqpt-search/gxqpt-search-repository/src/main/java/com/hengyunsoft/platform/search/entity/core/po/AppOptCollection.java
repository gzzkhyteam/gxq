package com.hengyunsoft.platform.search.entity.core.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;

import java.io.Serializable;
import java.util.Date;

public class AppOptCollection extends CommonBaseEntity<Long> implements Serializable {
    @Override
    public void setCreateTime(Date nowDate) {
        setUpdateTime(nowDate);
    }

    private Long id;

    /**
     * appid
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 集合id
     *
     * @mbggenerated
     */
    private Long collectionId;

    /**
     * 0,没有权限，1读，2写，3读写
     *
     * @mbggenerated
     */
    private Integer opt;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getCreateTime() {
        return null;
    }

    /**
     * appid
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * appid
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 集合id
     *
     * @mbggenerated
     */
    public Long getCollectionId() {
        return collectionId;
    }

    /**
     * 集合id
     *
     * @mbggenerated
     */
    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * 0,没有权限，1读，2写，3读写
     *
     * @mbggenerated
     */
    public Integer getOpt() {
        return opt;
    }

    /**
     * 0,没有权限，1读，2写，3读写
     *
     * @mbggenerated
     */
    public void setOpt(Integer opt) {
        this.opt = opt;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}