package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * @author tianai
 * @createTime 2018-02-2
 */
@Data
public class HolidayOriginalDataDTO extends BaseHolidayOriginalDataDTO implements Serializable {


    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * 节假日名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "节假日名称")
    private String name;
}
