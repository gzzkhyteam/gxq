package com.hengyunsoft.platform.file.entity.file.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class FileStatis extends CommonBaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    private String appId;

    private Long fileId;

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    private Integer downCount;

    /**
     * 上传次数
     *
     * @mbggenerated
     */
    private Integer uploadCount;

    private Date createTime;

    private Date updateTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    public Integer getDownCount() {
        return downCount;
    }

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }

    /**
     * 上传次数
     *
     * @mbggenerated
     */
    public Integer getUploadCount() {
        return uploadCount;
    }

    /**
     * 上传次数
     *
     * @mbggenerated
     */
    public void setUploadCount(Integer uploadCount) {
        this.uploadCount = uploadCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
}