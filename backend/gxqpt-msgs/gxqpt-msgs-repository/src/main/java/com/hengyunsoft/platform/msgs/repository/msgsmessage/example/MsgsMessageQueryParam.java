package com.hengyunsoft.platform.msgs.repository.msgsmessage.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MsgsMessageQueryParam {
    @ApiModelProperty(value = "消息id")
    private Long id;
    /**
     * 创建人id
     *
     * @mbggenerated
     */
    private Long createUser;
    /**
     * 消息状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "消息状态")
    private Long msgStatus;
    @ApiModelProperty(value = "消息类型")
    private int channelType;
    @ApiModelProperty(value = "消息名称")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTimeStart;

     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTimeEnd;

}
