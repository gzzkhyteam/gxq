package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author tianai
 * @createTime 2018-02-2
 */
@Data
@ApiModel(value = "HolidayDataSave", description = "节假日")
public class HolidayDataSaveDTO extends BaseHolidayDataDTO implements Serializable {


    /**
     * 节假日名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "节假日名称",required = true)
    private String name;

}
