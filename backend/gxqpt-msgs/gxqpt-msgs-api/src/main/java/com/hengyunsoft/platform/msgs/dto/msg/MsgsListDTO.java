package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MsgsListDTO {
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
    private Date sendTime;
	/**
     * 渠道类型
     */
    @ApiModelProperty(value = "消息ID")
    private Long channelType;
	/**
     * 渠道名称
     */
    @ApiModelProperty(value = "渠道名称")
    private String channelName; 
}
