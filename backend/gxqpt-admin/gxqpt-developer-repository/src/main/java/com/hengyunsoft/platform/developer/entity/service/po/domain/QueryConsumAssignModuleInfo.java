package com.hengyunsoft.platform.developer.entity.service.po.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryConsumAssignModuleInfo implements Serializable {

    /**
     * 功能ID
     *
     * @mbggenerated
     */
    private Long id;

    private Long assignModuleId;

    /**
     * 功能类型
     *
     * @mbggenerated
     */
    private String moduleTypeName;

    /**
     * 功能名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 功能编码
     *
     * @mbggenerated
     */
    private String code;

    /**
     * 申请人使用应用名称
     */
    private String appName;

    /**
     * 申请描述
     *
     * @mbggenerated
     */
    private String applyDesc;

    /**
     * 建议模块
     *
     * @mbggenerated
     */
    private Long adviceModule;

    /**
     * 状态： 1、正常使用中   10、已过时（有新版本取代）     20、停止使用
     *
     * @mbggenerated
     */
    private Short moduleStatus;

}