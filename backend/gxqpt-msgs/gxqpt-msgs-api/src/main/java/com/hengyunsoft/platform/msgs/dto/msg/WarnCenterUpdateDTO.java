package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class WarnCenterUpdateDTO {
	@ApiModelProperty(value = "主键ID")
	private Long id;
	/**
     * 消息主题
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "消息主题")
    private String topic;

    /**
     * 发布时间
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "发布时间")
    private Date sendTime;
    /**
     * 发布人
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "发布人")
    private String sender;

    /**
     * 消息发生地址
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "消息发生地址")
    private String url;
    /**
     * 创建人
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "创建人")
    private String createUser;
    /**
     * 创建人id
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "创建人ID")
    private String createUserId;   
}
