package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：查询预警处理人DTO
 * @author zjr
 * @date 2018/03/27
 * @return
 */
@Data
@ApiModel(value = "GxqptWarnHandler", description = "查询预警处理人")
public class GxqptWarnHandlerDTO implements Serializable{

    /**
     * 预警处理人
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警处理人")
    private List<String> handler;
}
