package com.hengyunsoft.platform.mail.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;

public class TimeAttachment extends BaseEntity<Long> implements Serializable {
    /**
     * 主键ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 文件名称
     *
     * @mbggenerated
     */
    private String fileName;

    /**
     * 文件url
     *
     * @mbggenerated
     */
    private String fileUrl;

    /**
     * 邮件ID
     *
     * @mbggenerated
     */
    private Long mailId;

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 文件名称
     *
     * @mbggenerated
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 文件名称
     *
     * @mbggenerated
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * 文件url
     *
     * @mbggenerated
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 文件url
     *
     * @mbggenerated
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    /**
     * 邮件ID
     *
     * @mbggenerated
     */
    public Long getMailId() {
        return mailId;
    }

    /**
     * 邮件ID
     *
     * @mbggenerated
     */
    public void setMailId(Long mailId) {
        this.mailId = mailId;
    }
}