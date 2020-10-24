package com.hengyunsoft.platform.warn.open.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：预警信息更新对外接口DTO
 * @author zjr
 * @date 2018/06/26
 *
 */
@Data
@ApiModel(value = "UpdateGxqptWarnOpen", description = "预警信息更新对外接口DTO")
public class UpdateGxqptWarnOpenDTO implements Serializable {
    /**
     * 主键TD
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 处理备注
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理备注")
    private String remarks;
    /**
     * 预警级别
     * @mbggenerated
     */
    private Integer level;
    /**
     * 处理结果标识
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理结果标识")
    private Boolean result;


    private static final long serialVersionUID = 1L;

}
