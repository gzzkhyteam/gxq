package com.hengyunsoft.platform.developer.api.fast.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenxiaoyuan
 * @create 2018-05-08
 * @desc 会议管理分页
 **/
@Data
@ApiModel(value = "Meet",description = "会议管理分页")
public class MeetNoticeDTO implements Serializable{
    @ApiModelProperty(value = "会议通知ID")
    private Long id;

    @ApiModelProperty(value = "应用ID")
    private String appId;

    @ApiModelProperty(value = "会议ID")
    private Long meetId;

    @ApiModelProperty(value = "会议名称")
    private String meetName;

    @ApiModelProperty(value = "会议地址")
    private String meetAddress;

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

    @ApiModelProperty(value = "会议状态")
    private Short meetStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "提醒时间")
    private Date noticeTime;

    @ApiModelProperty(value = "会议关联人员")
    private String empId;

    @ApiModelProperty(value = "关联人员类型")
    private Short empType;

    @ApiModelProperty(value = "是否参加")
    private Short joinStatus;

    @ApiModelProperty(value = "会议通知备注")
    private String remark;

    @ApiModelProperty(value = "会议备注")
    private String meetRemark;

    @ApiModelProperty(value = "与会人员")
    private String meetJoiners;

}