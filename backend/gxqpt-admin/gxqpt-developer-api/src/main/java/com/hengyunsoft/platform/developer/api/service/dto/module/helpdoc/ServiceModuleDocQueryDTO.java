package com.hengyunsoft.platform.developer.api.service.dto.module.helpdoc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "ServiceModuleDocQueryDTO", description = "帮助文档实体")
public class ServiceModuleDocQueryDTO implements Serializable{


    /**
     * 模块id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块id")
    private Long moduleId;


    /**
     * 标题
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 发布状态： 未发布、已发表
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布状态： 未发布、已发表")
    private Boolean publishStatus;


    /**
     * 是否公有资源（是否需要登陆方可查看）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否公有资源（是否需要登陆方可查看）")
    private Boolean publicIs;


    private static final long serialVersionUID = 1L;


}
