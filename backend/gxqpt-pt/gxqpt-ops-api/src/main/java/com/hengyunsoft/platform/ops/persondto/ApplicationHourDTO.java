package com.hengyunsoft.platform.ops.persondto;

import com.hengyunsoft.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author tianai
 * @createTime 2018-07-28
 */
@Data
public class ApplicationHourDTO  implements Serializable{

    @ApiModelProperty(value = "系统id总数")
    private Integer  count;
    @ApiModelProperty(value = "处理时长")
    private Integer  hour;


}
