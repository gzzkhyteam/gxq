package com.hengyunsoft.platform.ops.entity.file.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class OperationFile extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 业务id
     *
     * @mbggenerated
     */
    private Long bussId;

    /**
     * 业务类型:服务报告(service_report)，2服务成果(service_result)，
     * 培训签到表(train_sign_in),培训反馈表(train_feedback)
     * @mbggenerated
     */
    private String bussType;

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
     * 文件id
     *
     * @mbggenerated
     */
    private Long fileId;

    /**
     * 上传时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 上传人
     *
     * @mbggenerated
     */
    private Long userId;

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
     * 业务id
     *
     * @mbggenerated
     */
    public Long getBussId() {
        return bussId;
    }

    /**
     * 业务id
     *
     * @mbggenerated
     */
    public void setBussId(Long bussId) {
        this.bussId = bussId;
    }

    /**
     * 业务类型
     *
     * @mbggenerated
     */
    public String getBussType() {
        return bussType;
    }

    /**
     * 业务类型
     *
     * @mbggenerated
     */
    public void setBussType(String bussType) {
        this.bussType = bussType == null ? null : bussType.trim();
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
     * 上传人
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 上传人
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
}