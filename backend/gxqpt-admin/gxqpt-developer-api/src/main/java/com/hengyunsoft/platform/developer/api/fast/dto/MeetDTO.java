package com.hengyunsoft.platform.developer.api.fast.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class MeetDTO implements Serializable {
    @ApiModelProperty(value = "应用ID")
    private String appId;

    @ApiModelProperty(value = "会议ID")
    private Long id;

    @ApiModelProperty(value = "会议名称")
    private String name;

    @ApiModelProperty(value = "会议地址")
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "会议开始时间")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "会议结束时间")
    private Date endTime;

    @ApiModelProperty(value = "会议主持人")
    private String moderator;

    @ApiModelProperty(value = "出席领导")
    private String joinLeader;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "与会人员")
    private List<Long> joinerIds;
}