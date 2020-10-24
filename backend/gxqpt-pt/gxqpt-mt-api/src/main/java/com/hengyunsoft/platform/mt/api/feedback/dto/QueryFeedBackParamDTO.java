package com.hengyunsoft.platform.mt.api.feedback.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.api.feedback.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：查询意见反馈列表参数
 * 修改人：gbl
 * 修改时间：2018/6/22
 * 修改内容：
 */
@Data
@ApiModel(value = "QueryFeedBackParamDTO", description = "查询意见反馈列表参数")
public class QueryFeedBackParamDTO {
    @ApiModelProperty(value = "反馈标题")
    private String fbTitle;

    @ApiModelProperty(value = "反馈内容")
    private String fbContent;

    @ApiModelProperty(value = "紧急程度(1普通，2紧急，3非常紧急)")
    private Integer fbEmergency;

    @ApiModelProperty(value = " 处理状态（1未处理，2已处理,3已经关闭）")
    private Integer fbState;

    @ApiModelProperty(value = "开始创建时间(登记时间)")
    private Date startCreateTime;

    @ApiModelProperty(value = "结束创建时间(登记时间)")
    private Date endCreateTime;
}
