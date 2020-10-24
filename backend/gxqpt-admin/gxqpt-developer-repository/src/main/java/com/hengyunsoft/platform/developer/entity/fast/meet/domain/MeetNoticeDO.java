package com.hengyunsoft.platform.developer.entity.fast.meet.domain;

import com.hengyunsoft.platform.developer.entity.fast.meet.po.MeetNotice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/8.
 */
@Data
@ApiModel(value = "MeetNotice",description = "会议查询")
public class MeetNoticeDO implements Serializable {
    @ApiModelProperty(value = "会议通知ID")
    private Long id;

    @ApiModelProperty(value = "应用ID")
    private String appId;

    @ApiModelProperty(value = "会议ID")
    private Long meetId;

    @ApiModelProperty(value = "会议关联人员ID")
    private Long empId;

    @ApiModelProperty(value = "关联人员类型")
    private Short empType;

    @ApiModelProperty(value = "是否参加")
    private Short joinStatus;

    @ApiModelProperty(value = "参会备注")
    private String remark;

    @ApiModelProperty(value = "会议名称")
    private String meetName;

    @ApiModelProperty(value = "会议备注")
    private String meetRemark;

    @ApiModelProperty(value = "会议地址")
    private String meetAddress;

    @ApiModelProperty(value = "会议开始时间")
    private Date startTime;

    @ApiModelProperty(value = "会议结束时间")
    private Date endTime;

    @ApiModelProperty(value = "会议主持人")
    private String moderator;

    @ApiModelProperty(value = "出席领导")
    private String joinLeader;

    @ApiModelProperty(value = "出席领导")
    private Short meetStatus;

    @ApiModelProperty(value = "与会人员")
    private String meetJoiners;

    @ApiModelProperty(value = "提醒时间")
    private Date noticeTime;
}
