package com.hengyunsoft.platform.ops.consultdto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by kevin on 2018/7/16.
 */
@Data
@ApiModel(value = "ConsultApplyPageReq", description = "登陆人咨询分页查询条件")
public class ConsultApplyPageReqDTO implements Serializable {

    @ApiModelProperty(value = "开始时间" ,required = false)
    private String startTime;

    @ApiModelProperty(value = "截止时间",required = false)
    private String endTime;

    @ApiModelProperty(value = "咨询名称" ,required = false)
    private String consultName;

    @ApiModelProperty(value = "状态（未处理1、已处理2、已驳回3）" ,required = false)
    private Integer status;

    @ApiModelProperty(value = "申请编号",required = false)
    private String applyCode;

}
