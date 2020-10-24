package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：API列表查询条件
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiQueryCondition", description = "API列表查询条件")
public class ApiQueryConditionDTO {
    @ApiModelProperty(value = "API名称")
    private String apiName;
    @ApiModelProperty(value = "API状态（1,启用；2，禁用）")
    private Integer apiStatus;
    @ApiModelProperty(value = "状态（1,待审批；2，已驳回；3，审批通过）")
    private Integer authStatus;
    @ApiModelProperty(value = "单位Id")
    private String unitId;

}
