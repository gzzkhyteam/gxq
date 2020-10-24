package com.hengyunsoft.platform.developer.api.screen.dto.platform;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by kevin on 2018/5/1.
 */
@Data
public class PlatformUseInfoDTO {

    /**
     * 类型名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用类型")
    private String type;

    /**
     * 应用使用总数
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
