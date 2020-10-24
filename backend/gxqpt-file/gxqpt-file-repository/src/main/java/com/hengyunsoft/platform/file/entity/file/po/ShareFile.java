package com.hengyunsoft.platform.file.entity.file.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ShareFile extends CommonBaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 组织id
     *
     * @mbggenerated
     */
    private Long orgId;

    /**
     * 人员id
     *
     * @mbggenerated
     */
    private Long adminId;

    /**
     * 分享id
     *
     * @mbggenerated
     */
    private Long shareId;

    /**
     * 文件id
     *
     * @mbggenerated
     */
    private Long fileId;

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

    @Override
    public Date getUpdateTime() {
        return null;
    }

    @Override
    public void setCreateTime(Date nowDate) {

    }

    @Override
    public void setUpdateTime(Date nowDate) {

    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 组织id
     *
     * @mbggenerated
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 组织id
     *
     * @mbggenerated
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 人员id
     *
     * @mbggenerated
     */
    public Long getAdminId() {
        return adminId;
    }

    /**
     * 人员id
     *
     * @mbggenerated
     */
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    /**
     * 分享id
     *
     * @mbggenerated
     */
    public Long getShareId() {
        return shareId;
    }

    /**
     * 分享id
     *
     * @mbggenerated
     */
    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }

    /**
     * 文件id
     *
     * @mbggenerated
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * 文件id
     *
     * @mbggenerated
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
}