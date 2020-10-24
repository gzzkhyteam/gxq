package com.hengyunsoft.platform.hardware.entity.manage.domian;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.platform.hardware.entity.manage.po.DiskManage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ServerManageChangeDO extends BaseEntity<Long> implements Serializable {
    /**
     * 磁盘
     */
    private List<DiskManage> disks;
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
     * 服务器id
     *
     * @mbggenerated
     */
    private String serverId;

    /**
     * 服务器ip
     *
     * @mbggenerated
     */
    private String ip;

    /**
     * 管理单位id
     *
     * @mbggenerated
     */
    private String orgid;

    /**
     * 管理单位名称
     *
     * @mbggenerated
     */
    private String orgname;

    /**
     * 管理员id
     *
     * @mbggenerated
     */
    private String manageUid;

    /**
     * 管理员名称
     *
     * @mbggenerated
     */
    private String manageUname;

    /**
     * cpu核数
     *
     * @mbggenerated
     */
    private Integer cpuCount;

    /**
     * 内存大小
     *
     * @mbggenerated
     */
    private Integer memorySize;

    /**
     * 操作系统
     *
     * @mbggenerated
     */
    private String system;

    /**
     * 所属网络
     *
     * @mbggenerated
     */
    private String netScope;

    /**
     * 开通时间
     *
     * @mbggenerated
     */
    private Date openTime;

    /**
     * 网络带宽
     *
     * @mbggenerated
     */
    private Integer netWide;

    /**
     * 变更源（由哪条服务器记录变更而来）
     *
     * @mbggenerated
     */
    private Long pid;

    /**
     * 初始变更源（记录最开始被变更的服务器主键）
     *
     * @mbggenerated
     */
    private Long originId;

    /**
     * 变更次数（服务器变更次数）
     *
     * @mbggenerated
     */
    private Integer changeCount;

    /**
     * 变更状态（1已变更0未变更）
     *
     * @mbggenerated
     */
    private Boolean changeFlag;

    /**
     * 申请单号
     *
     * @mbggenerated
     */
    private String applyNo;

    /**
     * 审请人姓名
     *
     * @mbggenerated
     */
    private String applyUname;

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    private Date applyTime;

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
     * 服务器id
     *
     * @mbggenerated
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * 服务器id
     *
     * @mbggenerated
     */
    public void setServerId(String serverId) {
        this.serverId = serverId == null ? null : serverId.trim();
    }

    /**
     * 服务器ip
     *
     * @mbggenerated
     */
    public String getIp() {
        return ip;
    }

    /**
     * 服务器ip
     *
     * @mbggenerated
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 管理单位id
     *
     * @mbggenerated
     */
    public String getOrgid() {
        return orgid;
    }

    /**
     * 管理单位id
     *
     * @mbggenerated
     */
    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    /**
     * 管理单位名称
     *
     * @mbggenerated
     */
    public String getOrgname() {
        return orgname;
    }

    /**
     * 管理单位名称
     *
     * @mbggenerated
     */
    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    /**
     * 管理员id
     *
     * @mbggenerated
     */
    public String getManageUid() {
        return manageUid;
    }

    /**
     * 管理员id
     *
     * @mbggenerated
     */
    public void setManageUid(String manageUid) {
        this.manageUid = manageUid == null ? null : manageUid.trim();
    }

    /**
     * 管理员名称
     *
     * @mbggenerated
     */
    public String getManageUname() {
        return manageUname;
    }

    /**
     * 管理员名称
     *
     * @mbggenerated
     */
    public void setManageUname(String manageUname) {
        this.manageUname = manageUname == null ? null : manageUname.trim();
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
     * 所属网络
     *
     * @mbggenerated
     */
    public String getNetScope() {
        return netScope;
    }

    /**
     * 所属网络
     *
     * @mbggenerated
     */
    public void setNetScope(String netScope) {
        this.netScope = netScope == null ? null : netScope.trim();
    }

    /**
     * 开通时间
     *
     * @mbggenerated
     */
    public Date getOpenTime() {
        return openTime;
    }

    /**
     * 开通时间
     *
     * @mbggenerated
     */
    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    /**
     * 网络带宽
     *
     * @mbggenerated
     */
    public Integer getNetWide() {
        return netWide;
    }

    /**
     * 网络带宽
     *
     * @mbggenerated
     */
    public void setNetWide(Integer netWide) {
        this.netWide = netWide;
    }

    /**
     * 变更源（由哪条服务器记录变更而来）
     *
     * @mbggenerated
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 变更源（由哪条服务器记录变更而来）
     *
     * @mbggenerated
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 初始变更源（记录最开始被变更的服务器主键）
     *
     * @mbggenerated
     */
    public Long getOriginId() {
        return originId;
    }

    /**
     * 初始变更源（记录最开始被变更的服务器主键）
     *
     * @mbggenerated
     */
    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    /**
     * 变更次数（服务器变更次数）
     *
     * @mbggenerated
     */
    public Integer getChangeCount() {
        return changeCount;
    }

    /**
     * 变更次数（服务器变更次数）
     *
     * @mbggenerated
     */
    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    /**
     * 变更状态（1已变更0未变更）
     *
     * @mbggenerated
     */
    public Boolean getChangeFlag() {
        return changeFlag;
    }

    /**
     * 变更状态（1已变更0未变更）
     *
     * @mbggenerated
     */
    public void setChangeFlag(Boolean changeFlag) {
        this.changeFlag = changeFlag;
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

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getApplyUname() {
        return applyUname;
    }

    public void setApplyUname(String applyUname) {
        this.applyUname = applyUname;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public List<DiskManage> getDisks() {
        return disks;
    }

    public void setDisks(List<DiskManage> disks) {
        this.disks = disks;
    }
}