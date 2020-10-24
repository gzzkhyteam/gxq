package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgsBackListDTO", description = "消息黑名单列表对象")
public class MsgsBackListDTO {
	/**
     * 发布商名称
     */
    @ApiModelProperty(value = "发布商名称")
    private String name;
	/**
     * APPID
     */
    @ApiModelProperty(value = "APPID")
    private String appId;
	/**
     * 所属单位
     */
    @ApiModelProperty(value = "所属单位")
    private String orgName;
	/**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String status;
}
