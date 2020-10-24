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
@ApiModel(value = "HolidayOriginalDataSave", description = "节假日元数据")
public class HolidayOriginalDataSaveDTO  extends BaseHolidayOriginalDataDTO implements Serializable {


    /**
     * 节假日名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "节假日名称",required = true)
    private String name;

    @ApiModelProperty(value = "开始月日",required = true)
    private String startDate;

}
