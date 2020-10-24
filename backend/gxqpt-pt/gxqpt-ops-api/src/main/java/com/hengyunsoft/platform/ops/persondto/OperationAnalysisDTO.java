package com.hengyunsoft.platform.ops.persondto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author tianai
 * @createTime 2018-07-11
 */
@Data
public class OperationAnalysisDTO implements Serializable{

    @ApiModelProperty(value = "运维评分")
    private Double operationScore;
    @ApiModelProperty(value = "历史运维评分")
    private Double operationScoreLast;
    @ApiModelProperty(value = "应用评分")
    private Double applicationScore;

    @ApiModelProperty(value = "服务评分")
    private Double serviceScore;

    @ApiModelProperty(value = "培训评分")
    private Double trainScore;

    @ApiModelProperty(value = "咨询评分")
    private Double consultationScore;

    @ApiModelProperty(value = "统计故障数")
    private Map<String, Object> map ;

}
