package com.hengyunsoft.platform.modular.entity.modular.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ModularLog extends BaseEntity<Long> implements Serializable {
    /**
     * id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 模块id
     *
     * @mbggenerated
     */
    private Long modularId;

    /**
     * ip地址
     *
     * @mbggenerated
     */
    private String ip;

    /**
     * group_id
     *
     * @mbggenerated
     */
    private String groupId;

    /**
     * artifact_id
     *
     * @mbggenerated
     */
    private String artifactId;

    /**
     * jar包类型
     *
     * @mbggenerated
     */
    private String classifier;

    private String version;

    /**
     * 文件大小（单位：byte）
     *
     * @mbggenerated
     */
    private Integer fileSize;

    /**
     * 下载耗时（单位：毫秒）
     *
     * @mbggenerated
     */
    private Integer timeConsume;

    /**
     * 原始日志
     *
     * @mbggenerated
     */
    private String originaLog;

    private Long createUser;

    /**
     * 下载时间
     *
     * @mbggenerated
     */
    private Date createTime;

    private Long updateUser;

    private Date updateTime;

    /**
     * 仓库名称
     *
     * @mbggenerated
     */
    private String repName;

    private static final long serialVersionUID = 1L;

    /**
     * id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 模块id
     *
     * @mbggenerated
     */
    public Long getModularId() {
        return modularId;
    }

    /**
     * 模块id
     *
     * @mbggenerated
     */
    public void setModularId(Long modularId) {
        this.modularId = modularId;
    }

    /**
     * ip地址
     *
     * @mbggenerated
     */
    public String getIp() {
        return ip;
    }

    /**
     * ip地址
     *
     * @mbggenerated
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * group_id
     *
     * @mbggenerated
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * group_id
     *
     * @mbggenerated
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * artifact_id
     *
     * @mbggenerated
     */
    public String getArtifactId() {
        return artifactId;
    }

    /**
     * artifact_id
     *
     * @mbggenerated
     */
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId == null ? null : artifactId.trim();
    }

    /**
     * jar包类型
     *
     * @mbggenerated
     */
    public String getClassifier() {
        return classifier;
    }

    /**
     * jar包类型
     *
     * @mbggenerated
     */
    public void setClassifier(String classifier) {
        this.classifier = classifier == null ? null : classifier.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * 文件大小（单位：byte）
     *
     * @mbggenerated
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     * 文件大小（单位：byte）
     *
     * @mbggenerated
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 下载耗时（单位：毫秒）
     *
     * @mbggenerated
     */
    public Integer getTimeConsume() {
        return timeConsume;
    }

    /**
     * 下载耗时（单位：毫秒）
     *
     * @mbggenerated
     */
    public void setTimeConsume(Integer timeConsume) {
        this.timeConsume = timeConsume;
    }

    /**
     * 原始日志
     *
     * @mbggenerated
     */
    public String getOriginaLog() {
        return originaLog;
    }

    /**
     * 原始日志
     *
     * @mbggenerated
     */
    public void setOriginaLog(String originaLog) {
        this.originaLog = originaLog == null ? null : originaLog.trim();
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 下载时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 下载时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 仓库名称
     *
     * @mbggenerated
     */
    public String getRepName() {
        return repName;
    }

    /**
     * 仓库名称
     *
     * @mbggenerated
     */
    public void setRepName(String repName) {
        this.repName = repName == null ? null : repName.trim();
    }
}