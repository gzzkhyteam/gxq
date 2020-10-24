package com.hengyunsoft.platform.standard.entity.standard.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class StandardFileLog extends BaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 文件服务器文件id
     *
     * @mbggenerated
     */
    private Long documentId;

    /**
     * 操作用户id
     *
     * @mbggenerated
     */
    private Long operatorUserId;

    /**
     * 操作用户姓名
     *
     * @mbggenerated
     */
    private String operatorUserName;

    /**
     * 操作用户归属单位id
     *
     * @mbggenerated
     */
    private Long operatorCompanyId;

    /**
     * 操作时间
     *
     * @mbggenerated
     */
    private Date operatorTime;

    /**
     * IP
     *
     * @mbggenerated
     */
    private String ip;

    /**
     * 操作类型，down:下载；view：查看；upload：上传
     *
     * @mbggenerated
     */
    private String operatorType;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 文件服务器文件id
     *
     * @mbggenerated
     */
    public Long getDocumentId() {
        return documentId;
    }

    /**
     * 文件服务器文件id
     *
     * @mbggenerated
     */
    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    /**
     * 操作用户id
     *
     * @mbggenerated
     */
    public Long getOperatorUserId() {
        return operatorUserId;
    }

    /**
     * 操作用户id
     *
     * @mbggenerated
     */
    public void setOperatorUserId(Long operatorUserId) {
        this.operatorUserId = operatorUserId;
    }

    /**
     * 操作用户姓名
     *
     * @mbggenerated
     */
    public String getOperatorUserName() {
        return operatorUserName;
    }

    /**
     * 操作用户姓名
     *
     * @mbggenerated
     */
    public void setOperatorUserName(String operatorUserName) {
        this.operatorUserName = operatorUserName == null ? null : operatorUserName.trim();
    }

    /**
     * 操作用户归属单位id
     *
     * @mbggenerated
     */
    public Long getOperatorCompanyId() {
        return operatorCompanyId;
    }

    /**
     * 操作用户归属单位id
     *
     * @mbggenerated
     */
    public void setOperatorCompanyId(Long operatorCompanyId) {
        this.operatorCompanyId = operatorCompanyId;
    }

    /**
     * 操作时间
     *
     * @mbggenerated
     */
    public Date getOperatorTime() {
        return operatorTime;
    }

    /**
     * 操作时间
     *
     * @mbggenerated
     */
    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }

    /**
     * IP
     *
     * @mbggenerated
     */
    public String getIp() {
        return ip;
    }

    /**
     * IP
     *
     * @mbggenerated
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 操作类型，down:下载；view：查看；upload：上传
     *
     * @mbggenerated
     */
    public String getOperatorType() {
        return operatorType;
    }

    /**
     * 操作类型，down:下载；view：查看；upload：上传
     *
     * @mbggenerated
     */
    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType == null ? null : operatorType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}