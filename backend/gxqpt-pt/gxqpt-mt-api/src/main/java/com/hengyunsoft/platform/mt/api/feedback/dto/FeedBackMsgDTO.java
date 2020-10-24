package com.hengyunsoft.platform.mt.api.feedback.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.api.feedback.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：意见消息
 * 修改人：gbl
 * 修改时间：2018/6/22
 * 修改内容：
 */
@Data
@ApiModel(value = "FeedBackMsg", description = "意见消息")
public class FeedBackMsgDTO {
    @ApiModelProperty(value = "消息内容")
    private String msgContent;


    @ApiModelProperty(value = "创建者姓名")
    private String createUserName;


    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
