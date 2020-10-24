package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "CompanyInfo", description = "单位信息对象")
public class CompanyInfoDTO {
    /**
     *单位Id
     */
    @ApiModelProperty(value = "单位id")
    private String companyId;

    /**
     *单位名称
     */
    @ApiModelProperty(value = "单位名称")
    private String companyName;

}
