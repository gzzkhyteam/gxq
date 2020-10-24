package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgsListBackDTO", description = "消息列表对象")
public class MsgsListBackDTO {
	/**
     * 消息ID
     */
    @ApiModelProperty(value = "消息ID")
    private Long id;
	/**
     * 消息标题
     */
    @ApiModelProperty(value = "消息标题")
    private String title;
	/**
     * 发送时间
     */
    @ApiModelProperty(value = "发送时间")
    private String sendTime;
	/**
     * 渠道名称
     */
    @ApiModelProperty(value = "渠道名称")
    private String channelName; 	
    /**
     * 发布商名称
     */
    @ApiModelProperty(value = "发布商名称")
    private String appName; 
}
