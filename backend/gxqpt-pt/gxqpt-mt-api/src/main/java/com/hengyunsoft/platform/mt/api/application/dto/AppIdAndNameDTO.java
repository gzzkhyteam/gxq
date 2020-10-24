package com.hengyunsoft.platform.mt.api.application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.application.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：应用id名称
 * 修改人：gbl
 * 修改时间：2018/7/11
 * 修改内容：
 */
@Data
@ApiModel(value = "AppIdAndNameDTO", description = "应用id名称")
public class AppIdAndNameDTO {
    @ApiModelProperty(value = "应用id")
    private Long id;

    @ApiModelProperty(value = "应用名称")
    private String appName;
}
