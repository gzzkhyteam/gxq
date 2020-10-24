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
@ApiModel(value = "ConsultApplyPage", description = "登陆人咨询分页查询列表")
public class ConsultApplyPageDTO implements Serializable{


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

    @ApiModelProperty(value = "咨询内容",required = true)
    private String consultInfo;

    @ApiModelProperty(value = "提交单位",required = true)
    private String subDept;

    @ApiModelProperty(value = "申请编号",required = false)
    private String applyCode;
}
