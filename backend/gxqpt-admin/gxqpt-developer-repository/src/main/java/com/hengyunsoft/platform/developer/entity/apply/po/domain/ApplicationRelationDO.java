package com.hengyunsoft.platform.developer.entity.apply.po.domain;

import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import io.swagger.annotations.ApiModelProperty;

/**
 * 应用依赖关系DO
 */
public class ApplicationRelationDO extends Application{

    /**
     * 是否依赖
     */
    private Integer idRely;

    /**
     * 依赖应用Id
     */
    private Long target;

    /**
     * 依赖应用名称
     */
    private String targetName;

    /**
     * 关系表主键
     */
    private Long relationId;


    public Integer getIdRely() {
        return idRely;
    }

    public void setIdRely(Integer idRely) {
        this.idRely = idRely;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }
}