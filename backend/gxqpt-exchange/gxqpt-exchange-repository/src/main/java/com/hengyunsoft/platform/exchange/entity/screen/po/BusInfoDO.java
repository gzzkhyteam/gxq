package com.hengyunsoft.platform.exchange.entity.screen.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BusInfoDO implements Serializable{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "ID")
    private String id;
    @ApiModelProperty(value = "企业名称")
    private String investorEnterpriseName;
    @ApiModelProperty(value = "统一社会信用代码")
    private String creditCode;
    @ApiModelProperty(value = "法定代表人")
    private String legalRepresentative;
    @ApiModelProperty(value = "行业")
    private String industryType;
    @ApiModelProperty(value = "企业类型")
    private String companyType;
    @ApiModelProperty(value = "营业期限")
    private String businessTerm;
    @ApiModelProperty(value = "注册时间")
    private String registerTime;
    @ApiModelProperty(value = "登记机关")
    private String registerAuthority;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "员工人数")
    private String staffAmount;

}
