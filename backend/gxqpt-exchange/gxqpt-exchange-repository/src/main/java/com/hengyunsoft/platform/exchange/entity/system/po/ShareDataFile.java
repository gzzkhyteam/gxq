package com.hengyunsoft.platform.exchange.entity.system.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ShareDataFile extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 数据集id
     *
     * @mbggenerated
     */
    private Long setId;

    /**
     * 原附件名
     *
     * @mbggenerated
     */
    private String oldName;

    /**
     * 新附件名
     *
     * @mbggenerated
     */
    private String newName;

    /**
     * 附件类型
     *
     * @mbggenerated
     */
    private String fileType;

    /**
     * 附件大小
     *
     * @mbggenerated
     */
    private Double fileSize;

    /**
     * 附件路径
     *
     * @mbggenerated
     */
    private String filePath;

    /**
     * 业务id
     *
     * @mbggenerated
     */
    private Long busId;

    /**
     * 业务类型
     *
     * @mbggenerated
     */
    private String busType;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

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
     * 数据集id
     *
     * @mbggenerated
     */
    public Long getSetId() {
        return setId;
    }

    /**
     * 数据集id
     *
     * @mbggenerated
     */
    public void setSetId(Long setId) {
        this.setId = setId;
    }

    /**
     * 原附件名
     *
     * @mbggenerated
     */
    public String getOldName() {
        return oldName;
    }

    /**
     * 原附件名
     *
     * @mbggenerated
     */
    public void setOldName(String oldName) {
        this.oldName = oldName == null ? null : oldName.trim();
    }

    /**
     * 新附件名
     *
     * @mbggenerated
     */
    public String getNewName() {
        return newName;
    }

    /**
     * 新附件名
     *
     * @mbggenerated
     */
    public void setNewName(String newName) {
        this.newName = newName == null ? null : newName.trim();
    }

    /**
     * 附件类型
     *
     * @mbggenerated
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 附件类型
     *
     * @mbggenerated
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * 附件大小
     *
     * @mbggenerated
     */
    public Double getFileSize() {
        return fileSize;
    }

    /**
     * 附件大小
     *
     * @mbggenerated
     */
    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 附件路径
     *
     * @mbggenerated
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 附件路径
     *
     * @mbggenerated
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * 业务id
     *
     * @mbggenerated
     */
    public Long getBusId() {
        return busId;
    }

    /**
     * 业务id
     *
     * @mbggenerated
     */
    public void setBusId(Long busId) {
        this.busId = busId;
    }

    /**
     * 业务类型
     *
     * @mbggenerated
     */
    public String getBusType() {
        return busType;
    }

    /**
     * 业务类型
     *
     * @mbggenerated
     */
    public void setBusType(String busType) {
        this.busType = busType == null ? null : busType.trim();
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
     * 创建人
     *
     * @mbggenerated
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
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
     * 更新人
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}