package com.hengyunsoft.platform.hardware.entity.apply.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ApplyServer extends BaseEntity<Long> implements Serializable {
    /**
     * 磁盘
     */
    List<ApplyDisk> disks;
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 申请表主键
     *
     * @mbggenerated
     */
    private Long applyKeyid;

    /**
     * cpu核数
     *
     * @mbggenerated
     */
    private Integer cpuCount;

    /**
     * 内存
     *
     * @mbggenerated
     */
    private Long memorySize;

    /**
     * 操作系统
     *
     * @mbggenerated
     */
    private String system;

    /**
     * 系统盘大小
     *
     * @mbggenerated
     */
    private Integer sysDisksize;

    /**
     * 网络局域
     *
     * @mbggenerated
     */
    private String netScope;

    /**
     * 网络宽带
     *
     * @mbggenerated
     */
    private Integer netWide;

    /**
     * 网关描述
     *
     * @mbggenerated
     */
    private String gatewayDesc;

    /**
     * 申请数量
     *
     * @mbggenerated
     */
    private Integer applyCount;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 修改人
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * 修改时间
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
     * 申请表主键
     *
     * @mbggenerated
     */
    public Long getApplyKeyid() {
        return applyKeyid;
    }

    /**
     * 申请表主键
     *
     * @mbggenerated
     */
    public void setApplyKeyid(Long applyKeyid) {
        this.applyKeyid = applyKeyid;
    }

    /**
     * cpu核数
     *
     * @mbggenerated
     */
    public Integer getCpuCount() {
        return cpuCount;
    }

    /**
     * cpu核数
     *
     * @mbggenerated
     */
    public void setCpuCount(Integer cpuCount) {
        this.cpuCount = cpuCount;
    }

    /**
     * 内存
     *
     * @mbggenerated
     */
    public Long getMemorySize() {
        return memorySize;
    }

    /**
     * 内存
     *
     * @mbggenerated
     */
    public void setMemorySize(Long memorySize) {
        this.memorySize = memorySize;
    }

    /**
     * 操作系统
     *
     * @mbggenerated
     */
    public String getSystem() {
        return system;
    }

    /**
     * 操作系统
     *
     * @mbggenerated
     */
    public void setSystem(String system) {
        this.system = system == null ? null : system.trim();
    }

    /**
     * 系统盘大小
     *
     * @mbggenerated
     */
    public Integer getSysDisksize() {
        return sysDisksize;
    }

    /**
     * 系统盘大小
     *
     * @mbggenerated
     */
    public void setSysDisksize(Integer sysDisksize) {
        this.sysDisksize = sysDisksize;
    }

    /**
     * 网络局域
     *
     * @mbggenerated
     */
    public String getNetScope() {
        return netScope;
    }

    /**
     * 网络局域
     *
     * @mbggenerated
     */
    public void setNetScope(String netScope) {
        this.netScope = netScope == null ? null : netScope.trim();
    }

    /**
     * 网络宽带
     *
     * @mbggenerated
     */
    public Integer getNetWide() {
        return netWide;
    }

    /**
     * 网络宽带
     *
     * @mbggenerated
     */
    public void setNetWide(Integer netWide) {
        this.netWide = netWide;
    }

    /**
     * 网关描述
     *
     * @mbggenerated
     */
    public String getGatewayDesc() {
        return gatewayDesc;
    }

    /**
     * 网关描述
     *
     * @mbggenerated
     */
    public void setGatewayDesc(String gatewayDesc) {
        this.gatewayDesc = gatewayDesc == null ? null : gatewayDesc.trim();
    }

    /**
     * 申请数量
     *
     * @mbggenerated
     */
    public Integer getApplyCount() {
        return applyCount;
    }

    /**
     * 申请数量
     *
     * @mbggenerated
     */
    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
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

    public List<ApplyDisk> getDisks() {
        return disks;
    }

    public void setDisks(List<ApplyDisk> disks) {
        this.disks = disks;
    }
}