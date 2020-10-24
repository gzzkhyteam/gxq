package com.hengyunsoft.platform.developer.api.service.dto.module.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 描述:查询消费的功能实体
 * @author chb
 * @date 2018/4/4 10:45 
 */
@Data
@ApiModel(value = "AssignModuleNopageRet", description = "模块功能申请")
public class AssignModuleNopageRetDTO {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "AssignModuleId")
    private Long AssignModuleId;
    /**
     * 图标
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "图标")
    private String logo;

    /**
     * 功能名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能名称")
    private String name;


    /**
     * 功能描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能描述")
    private String desc;


    /**
     * 模块类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块类型")
    private String moduleType;

    private static final long serialVersionUID = 1L;
}
