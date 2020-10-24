package com.hengyunsoft.platform.standard.entity.standard.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "UploadCompanyDO", description = "上传标准单位")
public class UploadCompanyDO {

    @ApiModelProperty(value = "上传单位名称")
    private String name;
    @ApiModelProperty(value = "上传标准数量")
    private Integer count;
}
