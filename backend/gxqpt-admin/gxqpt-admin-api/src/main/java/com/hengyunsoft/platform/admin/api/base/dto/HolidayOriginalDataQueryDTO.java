package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @createTime 2018-04-26
 */
@Data
public class HolidayOriginalDataQueryDTO implements Serializable {

    /**
     * 编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编号")
    private String number;

    /**
     * 是否启用：1是，0否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否启用：1是，0否")
    private Integer status;

    /**
     * 节假日名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "节假日名称")
    private String name;
}
