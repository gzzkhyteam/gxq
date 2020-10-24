package com.hengyunsoft.platform.developer.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class ApplicationHostInstall extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @FieldDesc("主键")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    @FieldDesc("所属应用appid")
    @Length(max=64)
    private String appId;

    /**
     * 主机id
     *
     * @mbggenerated
     */
    @FieldDesc("主机id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long hostId;

    /**
     * 内存（单位M）
     *
     * @mbggenerated
     */
    @FieldDesc("内存（单位M）")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer mem;

    /**
     * 硬盘容量(单位M)
     *
     * @mbggenerated
     */
    @FieldDesc("硬盘容量(单位M)")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer harddisk;

    /**
     * 安装部署路径
     *
     * @mbggenerated
     */
    @FieldDesc("安装部署路径")
    @Length(max=60)
    private String installPath;

    /**
     * 应用版本
     *
     * @mbggenerated
     */
    @FieldDesc("应用版本")
    @Length(max=20)
    private String version;

    /**
     * 首页访问地址
     *
     * @mbggenerated
     */
    @FieldDesc("首页访问地址")
    @Length(max=255)
    private String indexUrl;

    /**
     * 备注
     *
     * @mbggenerated
     */
    @FieldDesc("备注")
    @Length(max=300)
    private String remark;

    /**
     * 状态     1、故障中；20、升级中；30、  运行中
     *
     * @mbggenerated
     */
    @FieldDesc("状态     1、故障中；20、升级中；30、  运行中")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer status;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    @FieldDesc("创建人id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    @FieldDesc("更新人id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
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