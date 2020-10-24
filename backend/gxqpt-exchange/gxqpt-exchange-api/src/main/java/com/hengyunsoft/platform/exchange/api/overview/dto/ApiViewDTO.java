package com.hengyunsoft.platform.exchange.api.overview.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ApiViewDTO {
    @ApiModelProperty(value = "API id")
    private Long id;
    @ApiModelProperty(value = "API名称")
    private String apiName;
    @ApiModelProperty(value = "api编码")
    private String apiCode;
    @ApiModelProperty(value = "API状态:1,启用；2，禁用")
    private Integer apiStatus;
    @ApiModelProperty(value = "api目录")
    private String dirName;
    @ApiModelProperty(value = " 审批状态:1,待审批；2，已驳回；3，审批通过")
    private Integer authStatus;
    @ApiModelProperty(value = "单位名称")
    private String unitName;
    @ApiModelProperty(value = " 创建用户Id")
    private Integer createUser;
    @ApiModelProperty(value = " 创建用户名")
    private String createUserName;
    @ApiModelProperty(value = " 创建时间")
    private Date createTime;
    @ApiModelProperty(value = "支持格式:1,json;2,xml")
    private Integer dataFmat;
    @ApiModelProperty(value = "API访问地址")
    private String  apiUrl;
    @ApiModelProperty(value = "单位Id")
    private String unitId;
    @ApiModelProperty
    private Boolean shareUnit;
}
