package com.hengyunsoft.platform.security.entity.assess.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ProgramRelease extends CommonBaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 版本名称
     *
     * @mbggenerated
     */
    private String versionName;

    /**
     * 版本号
     *
     * @mbggenerated
     */
    private String versionId;

    /**
     * 升级内容
     *
     * @mbggenerated
     */
    private String upgradeConent;

    /**
     * 升级时间
     *
     * @mbggenerated
     */
    private Date upgradeTime;

    /**
     * 发布文件id
     *
     * @mbggenerated
     */
    private Long upgradeFileId;

    /**
     * 发布文件链接
     *
     * @mbggenerated
     */
    private String upgradeFileUrl;

    /**
     * 发布文件名称
     *
     * @mbggenerated
     */
    private String upgradeFileName;

    /**
     * 服务ip
     *
     * @mbggenerated
     */
    private String serverIp;

    /**
     * 审批状态
     *
     * @mbggenerated
     */
    private Integer auditStatus;

    /**
     * 审批时间
     *
     * @mbggenerated
     */
    private Date auditTime;

    /**
     * 审批人
     *
     * @mbggenerated
     */
    private String auditUser;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remarks;

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
    private String createUser;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 修改人
     *
     * @mbggenerated
     */
    private String updateUser;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
     * 系统名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * 版本号
     *
     * @mbggenerated
     */
    public String getVersionId() {
        return versionId;
    }

    /**
     * 版本号
     *
     * @mbggenerated
     */
    public void setVersionId(String versionId) {
        this.versionId = versionId == null ? null : versionId.trim();
    }

    /**
     * 升级内容
     *
     * @mbggenerated
     */
    public String getUpgradeConent() {
        return upgradeConent;
    }

    /**
     * 升级内容
     *
     * @mbggenerated
     */
    public void setUpgradeConent(String upgradeConent) {
        this.upgradeConent = upgradeConent == null ? null : upgradeConent.trim();
    }

    /**
     * 升级时间
     *
     * @mbggenerated
     */
    public Date getUpgradeTime() {
        return upgradeTime;
    }

    /**
     * 升级时间
     *
     * @mbggenerated
     */
    public void setUpgradeTime(Date upgradeTime) {
        this.upgradeTime = upgradeTime;
    }

    /**
     * 发布文件id
     *
     * @mbggenerated
     */
    public Long getUpgradeFileId() {
        return upgradeFileId;
    }

    /**
     * 发布文件id
     *
     * @mbggenerated
     */
    public void setUpgradeFileId(Long upgradeFileId) {
        this.upgradeFileId = upgradeFileId;
    }

    /**
     * 发布文件链接
     *
     * @mbggenerated
     */
    public String getUpgradeFileUrl() {
        return upgradeFileUrl;
    }

    /**
     * 发布文件链接
     *
     * @mbggenerated
     */
    public void setUpgradeFileUrl(String upgradeFileUrl) {
        this.upgradeFileUrl = upgradeFileUrl == null ? null : upgradeFileUrl.trim();
    }

    /**
     * 发布文件名称
     *
     * @mbggenerated
     */
    public String getUpgradeFileName() {
        return upgradeFileName;
    }

    /**
     * 发布文件名称
     *
     * @mbggenerated
     */
    public void setUpgradeFileName(String upgradeFileName) {
        this.upgradeFileName = upgradeFileName == null ? null : upgradeFileName.trim();
    }

    /**
     * 服务ip
     *
     * @mbggenerated
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * 服务ip
     *
     * @mbggenerated
     */
    public void setServerIp(String serverIp) {
        this.serverIp = serverIp == null ? null : serverIp.trim();
    }

    /**
     * 审批状态
     *
     * @mbggenerated
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * 审批状态
     *
     * @mbggenerated
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 审批时间
     *
     * @mbggenerated
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 审批时间
     *
     * @mbggenerated
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 审批人
     *
     * @mbggenerated
     */
    public String getAuditUser() {
        return auditUser;
    }

    /**
     * 审批人
     *
     * @mbggenerated
     */
    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser == null ? null : auditUser.trim();
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }
}