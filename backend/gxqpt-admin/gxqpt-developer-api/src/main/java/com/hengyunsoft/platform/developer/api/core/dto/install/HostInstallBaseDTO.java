package com.hengyunsoft.platform.developer.api.core.dto.install;

import com.hengyunsoft.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class HostInstallBaseDTO extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 主机id
     *
     * @mbggenerated
     */
    private Long hostId;

    /**
     * 内存（单位M）
     *
     * @mbggenerated
     */
    private Integer mem;

    /**
     * 硬盘容量(单位M)
     *
     * @mbggenerated
     */
    private Integer harddisk;

    /**
     * 安装部署路径
     *
     * @mbggenerated
     */
    private String installPath;

    /**
     * 应用版本
     *
     * @mbggenerated
     */
    private String version;

    /**
     * 首页访问地址
     *
     * @mbggenerated
     */
    private String indexUrl;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * 状态     1、故障中；20、升级中；30、  运行中
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

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
     * 所属应用appid
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 主机id
     *
     * @mbggenerated
     */
    public Long getHostId() {
        return hostId;
    }

    /**
     * 主机id
     *
     * @mbggenerated
     */
    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    /**
     * 内存（单位M）
     *
     * @mbggenerated
     */
    public Integer getMem() {
        return mem;
    }

    /**
     * 内存（单位M）
     *
     * @mbggenerated
     */
    public void setMem(Integer mem) {
        this.mem = mem;
    }

    /**
     * 硬盘容量(单位M)
     *
     * @mbggenerated
     */
    public Integer getHarddisk() {
        return harddisk;
    }

    /**
     * 硬盘容量(单位M)
     *
     * @mbggenerated
     */
    public void setHarddisk(Integer harddisk) {
        this.harddisk = harddisk;
    }

    /**
     * 安装部署路径
     *
     * @mbggenerated
     */
    public String getInstallPath() {
        return installPath;
    }

    /**
     * 安装部署路径
     *
     * @mbggenerated
     */
    public void setInstallPath(String installPath) {
        this.installPath = installPath == null ? null : installPath.trim();
    }

    /**
     * 应用版本
     *
     * @mbggenerated
     */
    public String getVersion() {
        return version;
    }

    /**
     * 应用版本
     *
     * @mbggenerated
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * 首页访问地址
     *
     * @mbggenerated
     */
    public String getIndexUrl() {
        return indexUrl;
    }

    /**
     * 首页访问地址
     *
     * @mbggenerated
     */
    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl == null ? null : indexUrl.trim();
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
     * 状态     1、故障中；20、升级中；30、  运行中
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态     1、故障中；20、升级中；30、  运行中
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
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
}