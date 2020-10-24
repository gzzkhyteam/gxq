package com.hengyunsoft.platform.developer.api.screen.dto.platform;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlatformCommonDevDTO {

    /**
     * 类型名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用类型")
    private String type;

    /**
     * 应用总数
     * @mbggenerated
     */
    @ApiModelProperty(value = "总数")
    private Integer num;


    /**
     * 年月
     * @mbggenerated
     */
    @ApiModelProperty(value = "x轴")
    private String xDate;

}
