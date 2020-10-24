package com.hengyunsoft.platform.msgs.dto.msg;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "MsgsChannelGroupQuery", description = "渠道群组分页查询参数对象")
public class MsgsChannelGroupQueryDTO {

    /**
     *群组名称
     */
    @ApiModelProperty(value = "群组名称")
    private String name;
    /**
     *渠道名称
     */
    @ApiModelProperty(value = "渠道名称")
    private String channel;
    /**
     * 渠道类型
     */
    @ApiModelProperty(value = "渠道类型")
    private int channelType;
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
