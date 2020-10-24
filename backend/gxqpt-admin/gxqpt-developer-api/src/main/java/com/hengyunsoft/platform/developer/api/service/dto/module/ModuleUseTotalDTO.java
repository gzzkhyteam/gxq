package com.hengyunsoft.platform.developer.api.service.dto.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luchanghong
 * @create 2018-05-01 14:26
 * @desc 功能调用信息总量
 **/
@Data
@ApiModel(value = "模块调用总量", description = "模块调用总量")
public class ModuleUseTotalDTO {
    @ApiModelProperty(value = "模块调用总数")
    private Integer sumTotalNum;
}