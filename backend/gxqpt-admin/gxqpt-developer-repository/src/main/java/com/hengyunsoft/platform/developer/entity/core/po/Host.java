package com.hengyunsoft.platform.developer.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class Host extends BaseEntity<Long> implements Serializable {
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
     * 域名
     *
     * @mbggenerated
     */
    @FieldDesc("域名")
    @Length(max=32)
    private String domainName;

    /**
     * 公网ip地址
     *
     * @mbggenerated
     */
    @FieldDesc("公网ip地址")
    @Length(max=15)
    private String ipAddrPublic;

    /**
     * 内网ip地址
     *
     * @mbggenerated
     */
    @FieldDesc("内网ip地址")
    @Length(max=15)
    private String ipAddr;

    /**
     * 主机名
     *
     * @mbggenerated
     */
    @FieldDesc("主机名")
    @Length(max=64)
    private String hostName;

    /**
     * 操作系统类型(windows-server,linux,mac)
     *
     * @mbggenerated
     */
    @FieldDesc("操作系统类型(windows-server,linux,mac)")
    @Length(max=50)
    private String osType;

    /**
     * 操作系统版本号
     *
     * @mbggenerated
     */
    @FieldDesc("操作系统版本号")
    @Length(max=20)
    private String osVersion;

    /**
     * cpu信息
     *
     * @mbggenerated
     */
    @FieldDesc("cpu信息")
    @Length(max=40)
    private String cpuInfo;

    /**
     * CPU核数
     *
     * @mbggenerated
     */
    @FieldDesc("CPU核数")
    @Range(min=Short.MIN_VALUE,max=Short.MAX_VALUE)
    private Short cpuCount;

    /**
     * 服务商
     *
     * @mbggenerated
     */
    @FieldDesc("服务商")
    @Length(max=64)
    private String serverProvider;

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
     * 是否虚拟主机（ 1、否    2、是）
     *
     * @mbggenerated
     */
    @FieldDesc("是否虚拟主机（ 1、否    2、是）")
    @Range(min=Short.MIN_VALUE,max=Short.MAX_VALUE)
    private Short virtualHost;

    /**
     * 物理主机id
     *
     * @mbggenerated
     */
    @FieldDesc("物理主机id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long physicalHostId;

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

    /**
     * 备注
     *
     * @mbggenerated
     */
    @FieldDesc("备注")
    @Length(max=500)
    private String remark;

    /**
     * 主机状态（1.启用，2.停用）
     *
     * @mbggenerated
     */
    @FieldDesc("主机状态（1.启用，2.停用）")
    private Boolean status;

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
     * 域名
     *
     * @mbggenerated
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * 域名
     *
     * @mbggenerated
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName == null ? null : domainName.trim();
    }

    /**
     * 公网ip地址
     *
     * @mbggenerated
     */
    public String getIpAddrPublic() {
        return ipAddrPublic;
    }

    /**
     * 公网ip地址
     *
     * @mbggenerated
     */
    public void setIpAddrPublic(String ipAddrPublic) {
        this.ipAddrPublic = ipAddrPublic == null ? null : ipAddrPublic.trim();
    }

    /**
     * 内网ip地址
     *
     * @mbggenerated
     */
    public String getIpAddr() {
        return ipAddr;
    }

    /**
     * 内网ip地址
     *
     * @mbggenerated
     */
    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }

    /**
     * 主机名
     *
     * @mbggenerated
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * 主机名
     *
     * @mbggenerated
     */
    public void setHostName(String hostName) {
        this.hostName = hostName == null ? null : hostName.trim();
    }

    /**
     * 操作系统类型(windows-server,linux,mac)
     *
     * @mbggenerated
     */
    public String getOsType() {
        return osType;
    }

    /**
     * 操作系统类型(windows-server,linux,mac)
     *
     * @mbggenerated
     */
    public void setOsType(String osType) {
        this.osType = osType == null ? null : osType.trim();
    }

    /**
     * 操作系统版本号
     *
     * @mbggenerated
     */
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * 操作系统版本号
     *
     * @mbggenerated
     */
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion == null ? null : osVersion.trim();
    }

    /**
     * cpu信息
     *
     * @mbggenerated
     */
    public String getCpuInfo() {
        return cpuInfo;
    }

    /**
     * cpu信息
     *
     * @mbggenerated
     */
    public void setCpuInfo(String cpuInfo) {
        this.cpuInfo = cpuInfo == null ? null : cpuInfo.trim();
    }

    /**
     * CPU核数
     *
     * @mbggenerated
     */
    public Short getCpuCount() {
        return cpuCount;
    }

    /**
     * CPU核数
     *
     * @mbggenerated
     */
    public void setCpuCount(Short cpuCount) {
        this.cpuCount = cpuCount;
    }

    /**
     * 服务商
     *
     * @mbggenerated
     */
    public String getServerProvider() {
        return serverProvider;
    }

    /**
     * 服务商
     *
     * @mbggenerated
     */
    public void setServerProvider(String serverProvider) {
        this.serverProvider = serverProvider == null ? null : serverProvider.trim();
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
     * 是否虚拟主机（ 1、否    2、是）
     *
     * @mbggenerated
     */
    public Short getVirtualHost() {
        return virtualHost;
    }

    /**
     * 是否虚拟主机（ 1、否    2、是）
     *
     * @mbggenerated
     */
    public void setVirtualHost(Short virtualHost) {
        this.virtualHost = virtualHost;
    }

    /**
     * 物理主机id
     *
     * @mbggenerated
     */
    public Long getPhysicalHostId() {
        return physicalHostId;
    }

    /**
     * 物理主机id
     *
     * @mbggenerated
     */
    public void setPhysicalHostId(Long physicalHostId) {
        this.physicalHostId = physicalHostId;
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
     * 主机状态（1.启用，2.停用）
     *
     * @mbggenerated
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 主机状态（1.启用，2.停用）
     *
     * @mbggenerated
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }
}