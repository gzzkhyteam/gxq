package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MobileMsgsListBackDTO", description = "移动终端消息")
public class MobileMsgsListBackDTO {
	/**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;
	/**
     * 消息id
     */
    @ApiModelProperty(value = "消息id")
    private String msgId;
	/**
     * 消息标题
     */
    @ApiModelProperty(value = "消息标题")
    private String topic;
	/**
     * 消息封面地址
     */
    @ApiModelProperty(value = "消息封面地址")
    private String filePath;
	/**
     * 创建日期
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 信息摘要
     */
    @ApiModelProperty(value = "信息摘要")
    private String imgText;
    /**
     * 是否已读
     */
    @ApiModelProperty(value = "是否已读")
    private Boolean isRead = false;
}
