package com.hengyunsoft.platform.developer.api.core.dto.application;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ApplicationAllReq", description = "应用模糊查询传入实体")
public class ApplicationAllReqDTO {
    @ApiModelProperty(value = "应用名称")
    private String name;
    @ApiModelProperty(value = "单位名称")
    private String orgName;
    @ApiModelProperty(value = "页码")
    private Integer pageNo;
    @ApiModelProperty(value = "每页条数")
    private Integer pageSize;
}
