package com.hengyunsoft.platform.mt.entity.file.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;

import java.io.Serializable;
import java.util.Date;

public class File extends CommonBaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 主表id（业务id）
     *
     * @mbggenerated
     */
    private Long tableId;

    /**
     * 文件id
     *
     * @mbggenerated
     */
    private Long fileId;

    /**
     * 文件名
     *
     * @mbggenerated
     */
    private String fileName;

    /**
     * 文件大小
     *
     * @mbggenerated
     */
    private Integer fileSize;

    /**
     * 文件类型
     *
     * @mbggenerated
     */
    private String fileType;

    /**
     * 文件路径
     *
     * @mbggenerated
     */
    private String fileUrl;

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
     * 主键id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 主表id（业务id）
     *
     * @mbggenerated
     */
    public Long getTableId() {
        return tableId;
    }

    /**
     * 主表id（业务id）
     *
     * @mbggenerated
     */
    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    /**
     * 文件id
     *
     * @mbggenerated
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * 文件id
     *
     * @mbggenerated
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * 文件名
     *
     * @mbggenerated
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 文件名
     *
     * @mbggenerated
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * 文件大小
     *
     * @mbggenerated
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     * 文件大小
     *
     * @mbggenerated
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 文件类型
     *
     * @mbggenerated
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 文件类型
     *
     * @mbggenerated
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * 文件路径
     *
     * @mbggenerated
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 文件路径
     *
     * @mbggenerated
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
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

    @Override
    public String getAppId() {
        return null;
    }

    @Override
    public void setAppId(String appId) {

    }
}