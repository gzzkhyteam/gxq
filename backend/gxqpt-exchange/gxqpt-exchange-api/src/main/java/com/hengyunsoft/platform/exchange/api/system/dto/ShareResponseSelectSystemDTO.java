package com.hengyunsoft.platform.exchange.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ShareResponseSelectSystemDTO", description = "系统列表返回下拉框信息")
public class ShareResponseSelectSystemDTO implements Serializable {
    /**
     * 系统id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统id")
    private Long id;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    private String sysName;


}
