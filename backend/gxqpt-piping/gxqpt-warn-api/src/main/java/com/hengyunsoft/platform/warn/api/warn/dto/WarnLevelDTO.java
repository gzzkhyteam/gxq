package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：个人预警级别情况DTO
 * @author zjr
 * @date 2018/09/07
 * @return
 */
@Data
@ApiModel(value = "WarnLevel", description = "个人预警级别情况")
public class WarnLevelDTO implements Serializable{
    /**
     * 各个预警级别数量
     * @mbggenerated
     */
    @ApiModelProperty(value = "count")
    private Integer count;
    /**
     * 预警级别
     * @mbggenerated
     */
    @ApiModelProperty(value = "level")
    private Integer level;

    private static final long serialVersionUID = 1L;


}
