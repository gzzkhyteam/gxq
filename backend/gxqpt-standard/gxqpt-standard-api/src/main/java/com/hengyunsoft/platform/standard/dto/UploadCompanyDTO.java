package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "UploadCompanyDTO", description = "上传标准单位")
public class UploadCompanyDTO {

    @ApiModelProperty(value = "上传单位名称")
    private String name;
    @ApiModelProperty(value = "上传标准数量")
    private Integer count;
}
