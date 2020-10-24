package com.hengyunsoft.platform.ops.consultdto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kevin on 2018/7/16.
 */
@Data
@ApiModel(value = "ConsultDealPage", description = "处理人审批列表")
public class ConsultDealPageDTO implements Serializable{



    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "咨询名称")
    private String consultName;

    @ApiModelProperty(value = "咨询时间")
    private Date consultTime;

    @ApiModelProperty(value = "状态（未处理1、已处理2、已驳回3）")
    private Integer status;

    @ApiModelProperty(value = "评分")
    private Long score;

    @ApiModelProperty(value = "提交单位")
    private String subDept;

    @ApiModelProperty(value = "提交人")
    private String subPerson;

    @ApiModelProperty(value = "咨询人ID")
    private Long zxrId;

    @ApiModelProperty(value = "是否管理员角色")
    private Boolean isAdminRole;

    @ApiModelProperty(value = "申请编号",required = false)
    private String applyCode;

}
