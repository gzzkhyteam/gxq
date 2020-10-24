package com.hengyunsoft.platform.hardware.entity.equipmentMonitor.domain;

import java.io.Serializable;
import java.util.Date;

import com.hengyunsoft.base.entity.BaseEntity;

public class EquipmentMonitorReportDO extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 主机管理id
     *
     * @mbggenerated
     */
    private Long hostMgId;

    /**
     * 年
     *
     * @mbggenerated
     */
    private Integer year;

    /**
     * 月
     *
     * @mbggenerated
     */
    private Integer month;

    /**
     * 是否删除
     *
     * @mbggenerated
     */
    private Integer isDelete;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private String createUser;
    /**
     * 创建人名称
     *
     * @mbggenerated
     */
    private String createUserName;

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
     * 主机管理id
     *
     * @mbggenerated
     */
    public Long getHostMgId() {
        return hostMgId;
    }

    /**
     * 主机管理id
     *
     * @mbggenerated
     */
    public void setHostMgId(Long hostMgId) {
        this.hostMgId = hostMgId;
    }

    /**
     * 年
     *
     * @mbggenerated
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 年
     *
     * @mbggenerated
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 月
     *
     * @mbggenerated
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * 月
     *
     * @mbggenerated
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * 是否删除
     *
     * @mbggenerated
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除
     *
     * @mbggenerated
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
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
    
    
    /**
     * 文件大小
     *
     * @mbggenerated
     */
    private Integer fileSize;
    /**
     * 文件名称
     *
     * @mbggenerated
     */
    private String fileName;
    /**
     * 文件路径
     *
     * @mbggenerated
     */
    private String fileUrl;

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
    
}