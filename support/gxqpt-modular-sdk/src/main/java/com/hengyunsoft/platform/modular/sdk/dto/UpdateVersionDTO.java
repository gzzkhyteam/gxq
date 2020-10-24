package com.hengyunsoft.platform.modular.sdk.dto;

/**
 * 更新jar包的传参实体类
 *
 * @author zhoukx
 * @createTime 2018-4-16
 */
public class UpdateVersionDTO {

    /**
     * 仓库名
     * 该参数更新jar包时为必填项
     */
    private String repName;

    /**
     * groupId
     * 该参数更新jar包时为必填项
     */
    private String groupId;

    /**
     * artifactId
     * 该参数更新jar包时为必填项
     */
    private String artifactId;

    /**
     * 模块版本
     * 该参数更新jar包时为必填项
     */
    private String version;

    /**
     * jar包类型
     * 该参数更新jar包时为必填项
     * 参数填写规则为：
     * class文件 jar
     * 源码     source
     * API文档  doc
     * 帮助文档 help
     */
    private String classifier;

    /**
     * 单位Id
     * 该参数更新jar包时为必填项
     */
    private Long createCompanyId;

    /**
     * 单位名称
     * 该参数更新jar包时为必填项
     */
    private String createCompanyName;

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
}

