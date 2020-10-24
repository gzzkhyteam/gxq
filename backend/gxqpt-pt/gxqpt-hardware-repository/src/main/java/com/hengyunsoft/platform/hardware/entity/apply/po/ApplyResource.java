package com.hengyunsoft.platform.hardware.entity.apply.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ApplyResource extends BaseEntity<Long> implements Serializable {
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
     * cpu型号
     *
     * @mbggenerated
     */
    private String cpuModel;

    /**
     * 内存大小
     *
     * @mbggenerated
     */
    private Integer memorySize;

    /**
     * 内存规格
     *
     * @mbggenerated
     */
    private String memoryModel;

    /**
     * 磁盘大小
     *
     * @mbggenerated
     */
    private Long diskSize;

    /**
     * 磁盘规格
     *
     * @mbggenerated
     */
    private String diskModel;

    /**
     * 网卡数量
     *
     * @mbggenerated
     */
    private Integer netcardCount;

    /**
     * 网卡型号
     *
     * @mbggenerated
     */
    private String netcardModel;

    /**
     * 交换机数量
     *
     * @mbggenerated
     */
    private Integer changeMachine;

    /**
     * 交换机型号
     *
     * @mbggenerated
     */
    private String changeModel;

    /**
     * 光模块数量
     *
     * @mbggenerated
     */
    private Integer lightCount;

    /**
     * 光模块型号
     *
     * @mbggenerated
     */
    private String lightModel;

    /**
     * 独显数量
     *
     * @mbggenerated
     */
    private Integer videocardCount;

    /**
     * 独显型号
     *
     * @mbggenerated
     */
    private String videocardModel;

    /**
     * 需求说明
     *
     * @mbggenerated
     */
    private String remark;

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
     * cpu型号
     *
     * @mbggenerated
     */
    public String getCpuModel() {
        return cpuModel;
    }

    /**
     * cpu型号
     *
     * @mbggenerated
     */
    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel == null ? null : cpuModel.trim();
    }

    /**
     * 内存大小
     *
     * @mbggenerated
     */
    public Integer getMemorySize() {
        return memorySize;
    }

    /**
     * 内存大小
     *
     * @mbggenerated
     */
    public void setMemorySize(Integer memorySize) {
        this.memorySize = memorySize;
    }

    /**
     * 内存规格
     *
     * @mbggenerated
     */
    public String getMemoryModel() {
        return memoryModel;
    }

    /**
     * 内存规格
     *
     * @mbggenerated
     */
    public void setMemoryModel(String memoryModel) {
        this.memoryModel = memoryModel == null ? null : memoryModel.trim();
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
     * 磁盘规格
     *
     * @mbggenerated
     */
    public String getDiskModel() {
        return diskModel;
    }

    /**
     * 磁盘规格
     *
     * @mbggenerated
     */
    public void setDiskModel(String diskModel) {
        this.diskModel = diskModel == null ? null : diskModel.trim();
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
     * 网卡型号
     *
     * @mbggenerated
     */
    public String getNetcardModel() {
        return netcardModel;
    }

    /**
     * 网卡型号
     *
     * @mbggenerated
     */
    public void setNetcardModel(String netcardModel) {
        this.netcardModel = netcardModel == null ? null : netcardModel.trim();
    }

    /**
     * 交换机数量
     *
     * @mbggenerated
     */
    public Integer getChangeMachine() {
        return changeMachine;
    }

    /**
     * 交换机数量
     *
     * @mbggenerated
     */
    public void setChangeMachine(Integer changeMachine) {
        this.changeMachine = changeMachine;
    }

    /**
     * 交换机型号
     *
     * @mbggenerated
     */
    public String getChangeModel() {
        return changeModel;
    }

    /**
     * 交换机型号
     *
     * @mbggenerated
     */
    public void setChangeModel(String changeModel) {
        this.changeModel = changeModel == null ? null : changeModel.trim();
    }

    /**
     * 光模块数量
     *
     * @mbggenerated
     */
    public Integer getLightCount() {
        return lightCount;
    }

    /**
     * 光模块数量
     *
     * @mbggenerated
     */
    public void setLightCount(Integer lightCount) {
        this.lightCount = lightCount;
    }

    /**
     * 光模块型号
     *
     * @mbggenerated
     */
    public String getLightModel() {
        return lightModel;
    }

    /**
     * 光模块型号
     *
     * @mbggenerated
     */
    public void setLightModel(String lightModel) {
        this.lightModel = lightModel == null ? null : lightModel.trim();
    }

    /**
     * 独显数量
     *
     * @mbggenerated
     */
    public Integer getVideocardCount() {
        return videocardCount;
    }

    /**
     * 独显数量
     *
     * @mbggenerated
     */
    public void setVideocardCount(Integer videocardCount) {
        this.videocardCount = videocardCount;
    }

    /**
     * 独显型号
     *
     * @mbggenerated
     */
    public String getVideocardModel() {
        return videocardModel;
    }

    /**
     * 独显型号
     *
     * @mbggenerated
     */
    public void setVideocardModel(String videocardModel) {
        this.videocardModel = videocardModel == null ? null : videocardModel.trim();
    }

    /**
     * 需求说明
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 需求说明
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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