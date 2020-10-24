package com.hengyunsoft.platform.security.dto.interfaces;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class InterfaceConfigPageDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "模块ID")
    private String appId;

    @ApiModelProperty(value = "接口名称")
    private String apiName;

    @ApiModelProperty(value = "接口地址")
    private String apiUrl;

    @ApiModelProperty(value = "模块名称")
    private String modularName;

    @ApiModelProperty(value = "每5分钟错误次数")
    private Integer errorCountMinute;

    @ApiModelProperty(value = "每日上限次数（0：表示无限制）")
    private Integer upperLimitCountByDay;

    @ApiModelProperty(value = "是否短信通知（0：关闭，1：开启）")
    private Integer isSmsNotify;

    @ApiModelProperty(value = "电话号码")
    private String mobile;

    @ApiModelProperty(value = "是否已通知 0：未通知，1：已通知")
    private Integer isNotify;

    @ApiModelProperty(value = "设置状态 0：未设置，1：已设置")
    private Integer status;
    
    @ApiModelProperty(value = "修改人")
    private Long updateUser;

    @ApiModelProperty(value = "请求方式")
    private String method;
}
