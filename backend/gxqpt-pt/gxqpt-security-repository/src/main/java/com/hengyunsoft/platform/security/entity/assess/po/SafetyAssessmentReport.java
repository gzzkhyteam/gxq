package com.hengyunsoft.platform.security.entity.assess.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class SafetyAssessmentReport extends BaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 评估id
     *
     * @mbggenerated
     */
    private Long assessmentId;

    /**
     * 安全等级 0低 1中 2高
     *
     * @mbggenerated
     */
    private String level;

    /**
     * 评估时间
     *
     * @mbggenerated
     */
    private Date assessmentTime;

    /**
     * 评估报告id
     *
     * @mbggenerated
     */
    private Long assessmentFileId;

    /**
     * 评估文件名
     *
     * @mbggenerated
     */
    private String assessmentFileName;

    /**
     * 评估文件路径
     *
     * @mbggenerated
     */
    private String assessmentFileUrl;

    /**
     * 整改文件id
     *
     * @mbggenerated
     */
    private Long rectificationFileId;

    /**
     * 整改文件名
     *
     * @mbggenerated
     */
    private String rectificationFileName;

    /**
     * 整改文件路径
     *
     * @mbggenerated
     */
    private String rectificationFileUrl;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remarks;

    private Date createTime;

    private Long createUser;

    private Date updateTime;

    private Long updateUser;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 评估id
     *
     * @mbggenerated
     */
    public Long getAssessmentId() {
        return assessmentId;
    }

    /**
     * 评估id
     *
     * @mbggenerated
     */
    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }

    /**
     * 安全等级 0低 1中 2高
     *
     * @mbggenerated
     */
    public String getLevel() {
        return level;
    }

    /**
     * 安全等级 0低 1中 2高
     *
     * @mbggenerated
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * 评估时间
     *
     * @mbggenerated
     */
    public Date getAssessmentTime() {
        return assessmentTime;
    }

    /**
     * 评估时间
     *
     * @mbggenerated
     */
    public void setAssessmentTime(Date assessmentTime) {
        this.assessmentTime = assessmentTime;
    }

    /**
     * 评估报告id
     *
     * @mbggenerated
     */
    public Long getAssessmentFileId() {
        return assessmentFileId;
    }

    /**
     * 评估报告id
     *
     * @mbggenerated
     */
    public void setAssessmentFileId(Long assessmentFileId) {
        this.assessmentFileId = assessmentFileId;
    }

    /**
     * 评估文件名
     *
     * @mbggenerated
     */
    public String getAssessmentFileName() {
        return assessmentFileName;
    }

    /**
     * 评估文件名
     *
     * @mbggenerated
     */
    public void setAssessmentFileName(String assessmentFileName) {
        this.assessmentFileName = assessmentFileName == null ? null : assessmentFileName.trim();
    }

    /**
     * 评估文件路径
     *
     * @mbggenerated
     */
    public String getAssessmentFileUrl() {
        return assessmentFileUrl;
    }

    /**
     * 评估文件路径
     *
     * @mbggenerated
     */
    public void setAssessmentFileUrl(String assessmentFileUrl) {
        this.assessmentFileUrl = assessmentFileUrl == null ? null : assessmentFileUrl.trim();
    }

    /**
     * 整改文件id
     *
     * @mbggenerated
     */
    public Long getRectificationFileId() {
        return rectificationFileId;
    }

    /**
     * 整改文件id
     *
     * @mbggenerated
     */
    public void setRectificationFileId(Long rectificationFileId) {
        this.rectificationFileId = rectificationFileId;
    }

    /**
     * 整改文件名
     *
     * @mbggenerated
     */
    public String getRectificationFileName() {
        return rectificationFileName;
    }

    /**
     * 整改文件名
     *
     * @mbggenerated
     */
    public void setRectificationFileName(String rectificationFileName) {
        this.rectificationFileName = rectificationFileName == null ? null : rectificationFileName.trim();
    }

    /**
     * 整改文件路径
     *
     * @mbggenerated
     */
    public String getRectificationFileUrl() {
        return rectificationFileUrl;
    }

    /**
     * 整改文件路径
     *
     * @mbggenerated
     */
    public void setRectificationFileUrl(String rectificationFileUrl) {
        this.rectificationFileUrl = rectificationFileUrl == null ? null : rectificationFileUrl.trim();
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}