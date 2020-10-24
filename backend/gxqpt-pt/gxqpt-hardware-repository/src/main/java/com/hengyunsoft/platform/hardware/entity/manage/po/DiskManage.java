package com.hengyunsoft.platform.hardware.entity.manage.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class DiskManage extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 服务器管理表主键
     *
     * @mbggenerated
     */
    private Long serverId;

    /**
     * 磁盘id
     *
     * @mbggenerated
     */
    private String diskId;

    /**
     * 磁盘名称
     *
     * @mbggenerated
     */
    private String diskName;

    /**
     * 磁盘大小
     *
     * @mbggenerated
     */
    private Long diskSize;

    /**
     * 挂载点
     *
     * @mbggenerated
     */
    private String diskPath;

    /**
     * 磁盘属性（1数据盘，2系统盘）
     *
     * @mbggenerated
     */
    private String diskType;

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
     * 服务器管理表主键
     *
     * @mbggenerated
     */
    public Long getServerId() {
        return serverId;
    }

    /**
     * 服务器管理表主键
     *
     * @mbggenerated
     */
    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    /**
     * 磁盘id
     *
     * @mbggenerated
     */
    public String getDiskId() {
        return diskId;
    }

    /**
     * 磁盘id
     *
     * @mbggenerated
     */
    public void setDiskId(String diskId) {
        this.diskId = diskId == null ? null : diskId.trim();
    }

    /**
     * 磁盘名称
     *
     * @mbggenerated
     */
    public String getDiskName() {
        return diskName;
    }

    /**
     * 磁盘名称
     *
     * @mbggenerated
     */
    public void setDiskName(String diskName) {
        this.diskName = diskName == null ? null : diskName.trim();
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
     * 挂载点
     *
     * @mbggenerated
     */
    public String getDiskPath() {
        return diskPath;
    }

    /**
     * 挂载点
     *
     * @mbggenerated
     */
    public void setDiskPath(String diskPath) {
        this.diskPath = diskPath == null ? null : diskPath.trim();
    }

    /**
     * 磁盘属性（1数据盘，2系统盘）
     *
     * @mbggenerated
     */
    public String getDiskType() {
        return diskType;
    }

    /**
     * 磁盘属性（1数据盘，2系统盘）
     *
     * @mbggenerated
     */
    public void setDiskType(String diskType) {
        this.diskType = diskType == null ? null : diskType.trim();
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