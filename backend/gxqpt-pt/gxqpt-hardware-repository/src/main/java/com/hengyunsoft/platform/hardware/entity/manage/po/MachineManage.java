package com.hengyunsoft.platform.hardware.entity.manage.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class MachineManage extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 申请表主键（资源不足时为哪个申请进行资源补充便于展示）
     *
     * @mbggenerated
     */
    private Long applyKeyid;

    /**
     * 主机ip
     *
     * @mbggenerated
     */
    private String ip;

    /**
     * 所属集群（手动输入）
     *
     * @mbggenerated
     */
    private String cluster;

    /**
     * 型号
     *
     * @mbggenerated
     */
    private String model;

    /**
     * 处理器类型
     *
     * @mbggenerated
     */
    private String cpuType;

    /**
     * 处理器数量
     *
     * @mbggenerated
     */
    private Integer cpuCount;

    /**
     * 内存大小
     *
     * @mbggenerated
     */
    private Integer memory;

    /**
     * 网卡数量
     *
     * @mbggenerated
     */
    private Integer netcardCount;

    /**
     * 磁盘大小
     *
     * @mbggenerated
     */
    private Long diskSize;

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
     * 申请表主键（资源不足时为哪个申请进行资源补充便于展示）
     *
     * @mbggenerated
     */
    public Long getApplyKeyid() {
        return applyKeyid;
    }

    /**
     * 申请表主键（资源不足时为哪个申请进行资源补充便于展示）
     *
     * @mbggenerated
     */
    public void setApplyKeyid(Long applyKeyid) {
        this.applyKeyid = applyKeyid;
    }

    /**
     * 主机ip
     *
     * @mbggenerated
     */
    public String getIp() {
        return ip;
    }

    /**
     * 主机ip
     *
     * @mbggenerated
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 所属集群（手动输入）
     *
     * @mbggenerated
     */
    public String getCluster() {
        return cluster;
    }

    /**
     * 所属集群（手动输入）
     *
     * @mbggenerated
     */
    public void setCluster(String cluster) {
        this.cluster = cluster == null ? null : cluster.trim();
    }

    /**
     * 型号
     *
     * @mbggenerated
     */
    public String getModel() {
        return model;
    }

    /**
     * 型号
     *
     * @mbggenerated
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * 处理器类型
     *
     * @mbggenerated
     */
    public String getCpuType() {
        return cpuType;
    }

    /**
     * 处理器类型
     *
     * @mbggenerated
     */
    public void setCpuType(String cpuType) {
        this.cpuType = cpuType == null ? null : cpuType.trim();
    }

    /**
     * 处理器数量
     *
     * @mbggenerated
     */
    public Integer getCpuCount() {
        return cpuCount;
    }

    /**
     * 处理器数量
     *
     * @mbggenerated
     */
    public void setCpuCount(Integer cpuCount) {
        this.cpuCount = cpuCount;
    }

    /**
     * 内存大小
     *
     * @mbggenerated
     */
    public Integer getMemory() {
        return memory;
    }

    /**
     * 内存大小
     *
     * @mbggenerated
     */
    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    /**
     * 网卡数量
     *
     * @mbggenerated
     */
    public Integer getNetcardCount() {
        return netcardCount;
    }

    /**
     * 网卡数量
     *
     * @mbggenerated
     */
    public void setNetcardCount(Integer netcardCount) {
        this.netcardCount = netcardCount;
    }

    /**
     * 磁盘大小
     *
     * @mbggenerated
     */
    public Long getDiskSize() {
        return diskSize;
    }

    /**
     * 磁盘大小
     *
     * @mbggenerated
     */
    public void setDiskSize(Long diskSize) {
        this.diskSize = diskSize;
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
}