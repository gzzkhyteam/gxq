package com.hengyunsoft.platform.ops.faultdto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wt
 * @createTime 2018-07-27
 */
@Data
@ApiModel(value = "ResponseFMFindAnalyse", description = "应用分析查询返回信息")
public class ResponseFMFindAnalyseDTO implements Serializable{

    @ApiModelProperty(value = "应用评分")
    private Double appScore;

    @ApiModelProperty(value = "故障处理时间")
    private Double faultTimeAvg;

    @ApiModelProperty(value = "未处理故障数")
    private Integer untreatedFaultSum;

    @ApiModelProperty(value = "故障级别分析")
    private List<Double> faultLevel;

    @ApiModelProperty(value = "故障数量分析X轴")
    private List<Integer> faultSumX;

    @ApiModelProperty(value = "故障数量分析Y轴")
    private List<Integer> faultSumY;
}
