package com.hengyunsoft.platform.ops.persondto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author tianai
 * @createTime 2018-07-28
 */
@Data
public class ApplicationScoreDTO implements Serializable{

    @ApiModelProperty(value = "评分")
    private Integer  score;
}
