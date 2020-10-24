package com.hengyunsoft.platform.exchange.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ShareRequestSystemDTO", description = "数据字典request信息")
public class ShareRequestSystemDTO implements Serializable {

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    private String sysName;

    /**
     * 系统承建商
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统承建商")
    private String contractor;

    /**
     * 系统使用状态:1,在用；2，停用；3，整改中；
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统使用状态:1,在用；2，停用；3，整改中；")
    private Integer status;

    /**
     * 系统架构:1，BS; 2,CS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统架构:1，BS; 2,CS")
    private Integer sysArch;

    /**
     * 系统包含主要数据
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统包含主要数据")
    private String majorData;

}
