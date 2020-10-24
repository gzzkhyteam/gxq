package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author sunxiaoya
 * @create 2018-05-03
 * @desc 快速应用启用功能
 **/
@Data
@ApiModel(value = "FastApplicationStartUse",description = "快速应用启用功能")
public class FastApplicationStartUseDTO implements Serializable{
    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * 启用状态 （启用:true,禁用:false）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "启用状态")
    private String status;

}