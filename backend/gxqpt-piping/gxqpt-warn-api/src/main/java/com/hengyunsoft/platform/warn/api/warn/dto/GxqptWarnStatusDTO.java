package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：查询预警状态DTO
 * @author zjr
 * @date 2018/03/27
 * @return
 */
@Data
@ApiModel(value = "GxqptWarnStatus", description = "查询预警状态")
public class GxqptWarnStatusDTO implements Serializable{

    /**
     * 预警状态 1全部、 2 未处理、 3 已处理、 4 已忽略
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警状态 1全部、 2 未处理、 3 已处理、 4 已忽略")
    private List<String> status;
}
