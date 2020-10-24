package com.hengyunsoft.platform.file.entity.file.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class Share extends CommonBaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 组织ID
     *
     * @mbggenerated
     */
    private Long orgId;

    /**
     * 人员ID
     *
     * @mbggenerated
     */
    private Long adminId;

    /**
     * 人员姓名
     *
     * @mbggenerated
     */
    private String adminName;

    /**
     * 分享名称
     *
     * @mbggenerated
     */
    private String shareName;

    /**
     * 分享密码
     *
     * @mbggenerated
     */
    private String sharePassword;

    /**
     * 图标
     *
     * @mbggenerated
     */
    private String icon;

    /**
     * 链接
     *
     * @mbggenerated
     */
    private String url;

    /**
     * 有效期
     *
     * @mbggenerated
     */
    private Date valid;

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    private Integer downloadTimes;

    /**
     * 保存次数
     *
     * @mbggenerated
     */
    private Integer saveTimes;

    /**
     * 浏览次数
     *
     * @mbggenerated
     */
    private Integer browsTimes;

    private Date createTime;

    private Long createUser;

    private Date updateTime;

    private Long updateUser;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 组织ID
     *
     * @mbggenerated
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 组织ID
     *
     * @mbggenerated
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 人员ID
     *
     * @mbggenerated
     */
    public Long getAdminId() {
        return adminId;
    }

    /**
     * 人员ID
     *
     * @mbggenerated
     */
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    /**
     * 人员姓名
     *
     * @mbggenerated
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 人员姓名
     *
     * @mbggenerated
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * 分享名称
     *
     * @mbggenerated
     */
    public String getShareName() {
        return shareName;
    }

    /**
     * 分享名称
     *
     * @mbggenerated
     */
    public void setShareName(String shareName) {
        this.shareName = shareName == null ? null : shareName.trim();
    }

    /**
     * 分享密码
     *
     * @mbggenerated
     */
    public String getSharePassword() {
        return sharePassword;
    }

    /**
     * 分享密码
     *
     * @mbggenerated
     */
    public void setSharePassword(String sharePassword) {
        this.sharePassword = sharePassword == null ? null : sharePassword.trim();
    }

    /**
     * 图标
     *
     * @mbggenerated
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 图标
     *
     * @mbggenerated
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 链接
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * 链接
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 有效期
     *
     * @mbggenerated
     */
    public Date getValid() {
        return valid;
    }

    /**
     * 有效期
     *
     * @mbggenerated
     */
    public void setValid(Date valid) {
        this.valid = valid;
    }

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    public void setDownloadTimes(Integer downloadTimes) {
        this.downloadTimes = downloadTimes;
    }

    /**
     * 保存次数
     *
     * @mbggenerated
     */
    public Integer getSaveTimes() {
        return saveTimes;
    }

    /**
     * 保存次数
     *
     * @mbggenerated
     */
    public void setSaveTimes(Integer saveTimes) {
        this.saveTimes = saveTimes;
    }

    /**
     * 浏览次数
     *
     * @mbggenerated
     */
    public Integer getBrowsTimes() {
        return browsTimes;
    }

    /**
     * 浏览次数
     *
     * @mbggenerated
     */
    public void setBrowsTimes(Integer browsTimes) {
        this.browsTimes = browsTimes;
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

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}