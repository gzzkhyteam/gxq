package com.hengyunsoft.platform.developer.api.screen.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "OrgTitle",description = "大屏单位横幅计数")
public class OrgTitleDTO {
    @ApiModelProperty(value = "接入数量")
    private Integer access;

    @ApiModelProperty(value = "机构总数")
    private Integer orgNum;

    @ApiModelProperty(value = "应用总数")
    private Integer appNum;
}
