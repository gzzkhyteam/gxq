package com.hengyunsoft.platform.developer.api.service.dto.module.apply;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryConsumAssignModuleInfoDTO implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     *AssignModuleId
     */
    @ApiModelProperty(value = "assignModuleId")
    private Long assignModuleId;

    /**
     * 功能类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能类型")
    private String moduleTypeName;

    /**
     * 功能名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能名称")
    private String name;

    /**
     * 功能编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能编码")
    private String code;

    /**
     * 申请人使用应用名称
     */
    @ApiModelProperty(value = "申请人使用应用名称")
    private String appName;

    /**
     * 申请描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请描述")
    private String applyDesc;

    /**
     * 建议模块
     *
     * @mbggenerated
     */
    private Long adviceModule;

    /**
     * 建议模块名称
     *
     * @mbggenerated
     */
    private String adviceModuleName;

    /**
     * 状态： 1、正常使用中   10、已过时（有新版本取代）     20、停止使用
     *
     * @mbggenerated
     */
    private Short moduleStatus;
}