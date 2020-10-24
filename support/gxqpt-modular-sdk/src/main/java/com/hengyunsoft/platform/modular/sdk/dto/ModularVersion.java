package com.hengyunsoft.platform.modular.sdk.dto;

import java.util.Date;

/**
 * jar包实体类
 *
 * @author zkx
 * @create_time 2018-4-16
 */
public class ModularVersion {
    /**
     * id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 仓库名称
     *
     * @mbggenerated
     */
    private String repName;

    /**
     * groupId
     *
     * @mbggenerated
     */
    private String groupId;

    /**
     * artifactId
     *
     * @mbggenerated
     */
    private String artifactId;

    /**
     * 版本号
     *
     * @mbggenerated
     */
    private String version;

    /**
     * jar包类型
     *
     * @mbggenerated
     */
    private String classifier;

    /**
     * 上传人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 上传用户姓名
     *
     * @mbggenerated
     */
    private String createUserName;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 更新用户姓名
     *
     * @mbggenerated
     */
    private String updateUserName;

    /**
     * 上传时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 上传单位Id
     *
     * @mbggenerated
     */
    private Long createCompanyId;

    /**
     * 上传单位名称
     *
     * @mbggenerated
     */
    private String createCompanyName;

    /**
     * 下载次数
     */
    private Integer downloadCount;

    /**
     * 下载路径
     */
    private String downloadUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getClassifier() {
        return classifier;
    }

    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
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

    public Long getCreateCompanyId() {
        return createCompanyId;
    }

    public void setCreateCompanyId(Long createCompanyId) {
        this.createCompanyId = createCompanyId;
    }

    public String getCreateCompanyName() {
        return createCompanyName;
    }

    public void setCreateCompanyName(String createCompanyName) {
        this.createCompanyName = createCompanyName;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}