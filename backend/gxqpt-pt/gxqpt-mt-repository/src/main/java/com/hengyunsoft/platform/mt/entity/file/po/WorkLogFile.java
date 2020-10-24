package com.hengyunsoft.platform.mt.entity.file.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class WorkLogFile extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 详情
     *
     * @mbggenerated
     */
    private Long logDetailId;

    /**
     * 主表id
     *
     * @mbggenerated
     */
    private Long logId;

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
     * 上传时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 上传用户id
     *
     * @mbggenerated
     */
    private Long userId;

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
     * 详情
     *
     * @mbggenerated
     */
    public Long getLogDetailId() {
        return logDetailId;
    }

    /**
     * 详情
     *
     * @mbggenerated
     */
    public void setLogDetailId(Long logDetailId) {
        this.logDetailId = logDetailId;
    }

    /**
     * 主表id
     *
     * @mbggenerated
     */
    public Long getLogId() {
        return logId;
    }

    /**
     * 主表id
     *
     * @mbggenerated
     */
    public void setLogId(Long logId) {
        this.logId = logId;
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
     * 上传时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 上传时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 上传用户id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 上传用户id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}