package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgsChannelQuery", description = "渠道分页查询参数对象")
public class MsgsChannelQueryDTO {

    /**
     * 渠道类型
     */
    @ApiModelProperty(value = "渠道类型")
    private Integer channelType;

    /**
     * 渠道名称
     */
    @ApiModelProperty(value = "渠道名称")
    private String name;


    /**
     *创建开始时间
     */
    @ApiModelProperty(value = "创建开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTimeStart;

    /**
     *创建截止时间
     */
    @ApiModelProperty(value = "创建截止时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTimeEnd;

}
