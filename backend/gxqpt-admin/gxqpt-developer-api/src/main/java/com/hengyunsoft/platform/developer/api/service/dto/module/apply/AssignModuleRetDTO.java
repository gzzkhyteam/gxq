package com.hengyunsoft.platform.developer.api.service.dto.module.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "AssignModuleRet", description = "模块数据返回")
public class AssignModuleRetDTO implements Serializable {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 是否公有资源
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否公有资源")
    private Boolean publicIs;

    /**
     * 功能id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能id")
    private Long moduleId;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属应用appid")
    private String appId;

    /**
     * 状态： 1启用   2禁用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态： 1启用   2禁用")
    private Boolean status;

    /**
     * 禁用备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "禁用备注")
    private String disableDesc;

    private static final long serialVersionUID = 1L;
}
