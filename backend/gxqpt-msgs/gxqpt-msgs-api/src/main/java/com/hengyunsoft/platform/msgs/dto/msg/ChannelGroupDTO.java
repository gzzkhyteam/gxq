package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ChannelGroupDTO", description = "渠道群组对象")
public class ChannelGroupDTO {
	@ApiModelProperty(value = "渠道群组ID")
	private Long id;
	@ApiModelProperty(value = "渠道群组名称")
	private String name;
	@ApiModelProperty(value = "渠道群组包含渠道名称")
	private String channelNames;
	@ApiModelProperty(value = "渠道群组说明")
	private String explain;
    @ApiModelProperty(value = "渠道群组创建时间",required = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;
}
