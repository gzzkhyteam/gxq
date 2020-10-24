package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author sunxiaoya
 * @create 2018-05-03
 * @desc 快速应用菜单请求DTO
 **/
@Data
@ApiModel(value = "FastMenuReq",description = "快速应用菜单请求DTO")
public class FastMenuReqDTO implements Serializable{
    /**
     * 父ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "parentId")
    private Long parentId;

    /**
     * 应用ID
     *
     * @mbggenerated
     *
     */
    @ApiModelProperty(value = "appId")
    private String appId;


}