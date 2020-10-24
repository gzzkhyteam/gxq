package com.hengyunsoft.platform.modular.sdk.dto;


/**
 * 查询jar包列表的传参实体类
 *
 * @author zhoukx
 * @createTime 2018-4-16
 */
public class ModularVersionQueryDTO {

    /**
     * 仓库名
     */
    private String repName;

    /**
     * 模块名
     */
    private String modularName;

    /**
     * groupId
     */
    private String groupId;

    /**
     * artifactId
     */
    private String artifactId;

    /**
     * 版本号
     */
    private String version;

    /**
     * 模块描述
     */
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
