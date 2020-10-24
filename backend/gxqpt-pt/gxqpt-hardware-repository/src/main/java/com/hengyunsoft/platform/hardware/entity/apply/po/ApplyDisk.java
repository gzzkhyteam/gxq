package com.hengyunsoft.platform.hardware.entity.apply.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ApplyDisk extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 服务器资源id
     *
     * @mbggenerated
     */
    private Long applyServerid;

    /**
     * 磁盘属性（1数据盘，2系统盘）
     *
     * @mbggenerated
     */
    private Integer diskType;

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
     * 服务器资源id
     *
     * @mbggenerated
     */
    public Long getApplyServerid() {
        return applyServerid;
    }

    /**
     * 服务器资源id
     *
     * @mbggenerated
     */
    public void setApplyServerid(Long applyServerid) {
        this.applyServerid = applyServerid;
    }

    /**
     * 磁盘属性（1数据盘，2系统盘）
     *
     * @mbggenerated
     */
    public Integer getDiskType() {
        return diskType;
    }

    /**
     * 磁盘属性（1数据盘，2系统盘）
     *
     * @mbggenerated
     */
    public void setDiskType(Integer diskType) {
        this.diskType = diskType;
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