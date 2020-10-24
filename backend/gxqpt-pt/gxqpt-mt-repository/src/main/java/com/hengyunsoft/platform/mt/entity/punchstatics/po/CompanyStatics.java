package com.hengyunsoft.platform.mt.entity.punchstatics.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CompanyStatics {
    @ApiModelProperty(value = "企业数量")
    private int companyNum;
    @ApiModelProperty(value = "本月新增")
    private int monthNum;
    @ApiModelProperty(value = "总资产")
    private int property;
    @ApiModelProperty(value = "在职人数")
    private int personNum;

    @ApiModelProperty(value = "申报数量")
    private int projectDeclare;
    @ApiModelProperty(value = "版权登记")
    private int technical;
    @ApiModelProperty(value = "软件著作权")
    private int investment;
    @ApiModelProperty(value = "，IDC资质")
    private int cultivate;
}
