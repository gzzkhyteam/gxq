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
@ApiModel(value = "BWList", description = "新增黑名单")
public class BWListDTO implements Serializable {

    /**
     * 地址值,json格式[{"value":"xxx"},{"value":"xxx"}]
     * @mbggenerated
     */
    @ApiModelProperty(value = "地址值")
    private List<ValueDTO> value;

}
