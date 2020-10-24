package com.hengyunsoft.platform.modular.sdk.dto;


import java.util.Date;
import java.util.List;

/**
 * 模块的实体类
 *
 * @author zkx
 * @create_time 2018-4-16
 */
public class Modular {
    /**
     * 模块主键id
     */
    private Long id;

    /**
     * 仓库名称
     */
    private String repName;

    /**
     * 模块名称
     */
    private String modularName;

    /**
     * 模块分类
     */
    private String modularType;

    /**
     * 模块标签
     */
    private String modularTag;

    /**
     * groupId
     */
    private String groupId;

    /**
     * artifactId
     */
    private String artifactId;

    /**
     * 模块描述
     */
    private String description;

    /**
     * jar包类型
     */
    private String classifier;

    /**
     * 上传时间
     */
    private Date createTime;

    /**
     * 下载次数
     */
    private Integer downloadCount;

    /**
     * 模块的分类列表
     */
    private List mclist;

    /**
     * 模块的标签列表
     */
    private List mtlist;

    /**
     * 模块的版本列表
     */
    private List mdVersionlist;

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

    public String getModularName() {
        return modularName;
    }

    public void setModularName(String modularName) {
        this.modularName = modularName;
    }

    public String getModularType() {
        return modularType;
    }

    public void setModularType(String modularType) {
        this.modularType = modularType;
    }

    public String getModularTag() {
        return modularTag;
    }

    public void setModularTag(String modularTag) {
        this.modularTag = modularTag;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassifier() {
        return classifier;
    }

    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public List getMclist() {
        return mclist;
    }

    public void setMclist(List mclist) {
        this.mclist = mclist;
    }

    public List getMtlist() {
        return mtlist;
    }

    public void setMtlist(List mtlist) {
        this.mtlist = mtlist;
    }

    public List getMdVersionlist() {
        return mdVersionlist;
    }

    public void setMdVersionlist(List mdVersionlist) {
        this.mdVersionlist = mdVersionlist;
    }
}
