package com.hengyunsoft.platform.mt.api.feedback.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.api.feedback.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：意见反馈基本信息
 * 修改人：gbl
 * 修改时间：2018/6/22
 * 修改内容：
 */
@Data
@ApiModel(value = "FeedBackBase", description = "意见反馈基本信息")
public class FeedBackBaseDTO {
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "应用id")
    private Long appliId;

    @ApiModelProperty(value = "应用名称")
    private String appName;

    @ApiModelProperty(value = "反馈标题")
    private String fbTitle;

    @ApiModelProperty(value = "反馈内容")
    private String fbContent;

    @ApiModelProperty(value = "紧急程度(1普通，2紧急，3非常紧急)")
    private Integer fbEmergency;

    @ApiModelProperty(value = "处理状态（1未处理，2已处理,3已经关闭）")
    private Integer fbState;

    @ApiModelProperty(value = "关闭人姓名")
    private String fbCloseName;

    @ApiModelProperty(value = "关闭时间")
    private Date fbCloseTime;

    @ApiModelProperty(value = "创建人姓名")
    private String createUserName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "总消息")
    private Integer msgTotal;
    @ApiModelProperty(value = "未读消息")
    private Integer msgNotRead;
}
