package com.hengyunsoft.platform.mail.dto.bwlist;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zjr
 * @date 2018/08/08
 */
@Data
@ApiModel(value = "Value", description = "新增黑名单")
public class ValueDTO implements Serializable {

    /**
     * 地址值
     * @mbggenerated
     */
    @ApiModelProperty(value = "地址值")
    private String value;

}
