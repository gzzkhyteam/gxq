package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author tianai
 * @createTime 2018-2-2
 */
@Data
@ApiModel(value = "HolidayOriginalDataUpdate", description = "数据字典")
public class HolidayOriginalDataUpdateDTO extends BaseHolidayOriginalUpDateDTO implements Serializable {


    /**
     * 节假日元数据id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "节假日元数据id" ,required = true)
    private Long id;

    /**
     * 开始月日
     */
    @ApiModelProperty(value = "开始月日",required = true)
    private String startDate;
}
