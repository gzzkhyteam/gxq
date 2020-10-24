package com.hengyunsoft.platform.ops.entity.fault.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *运维分析
 */
@Data
public class ScoreCountDO implements Serializable{

    @ApiModelProperty(value = "业务记录数")
    private Integer  count;
    @ApiModelProperty(value = "评分")
    private Integer  score;




}
