package com.hengyunsoft.platform.ops.entity.application.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ApplicationUpdate extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 系统id
     *
     * @mbggenerated
     */
    private String systemId;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    private String systemName;

    /**
     * 发布日期
     *
     * @mbggenerated
     */
    private Date publishDate;

    /**
     * 版本名称
     *
     * @mbggenerated
     */
    private String versionName;

    /**
     * 发布版本号
     *
     * @mbggenerated
     */
    private String versionNumber;

    /**
     * 升级内容
     *
     * @mbggenerated
     */
    private String upgradeContent;

    /**
     * 发布服务器
     *
     * @mbggenerated
     */
    private String publishingServer;

    /**
     * 状态
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

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

    /**
     * 系统id
     *
     * @mbggenerated
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * 系统id
     *
     * @mbggenerated
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    /**
     * 发布日期
     *
     * @mbggenerated
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * 发布日期
     *
     * @mbggenerated
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 版本名称
     *
     * @mbggenerated
     */
    public String getVersionName() {
        return versionName;
    }

    /**
     * 版本名称
     *
     * @mbggenerated
     */
    public void setVersionName(String versionName) {
        this.versionName = versionName == null ? null : versionName.trim();
    }

    /**
     * 发布版本号
     *
     * @mbggenerated
     */
    public String getVersionNumber() {
        return versionNumber;
    }

    /**
     * 发布版本号
     *
     * @mbggenerated
     */
    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber == null ? null : versionNumber.trim();
    }

    /**
     * 升级内容
     *
     * @mbggenerated
     */
    public String getUpgradeContent() {
        return upgradeContent;
    }

    /**
     * 升级内容
     *
     * @mbggenerated
     */
    public void setUpgradeContent(String upgradeContent) {
        this.upgradeContent = upgradeContent == null ? null : upgradeContent.trim();
    }

    /**
     * 发布服务器
     *
     * @mbggenerated
     */
    public String getPublishingServer() {
        return publishingServer;
    }

    /**
     * 发布服务器
     *
     * @mbggenerated
     */
    public void setPublishingServer(String publishingServer) {
        this.publishingServer = publishingServer == null ? null : publishingServer.trim();
    }

    /**
     * 状态
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}