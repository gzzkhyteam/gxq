package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：gbl
 * 修改时间：2018/9/5
 * 修改内容：
 */
@Data
@ApiModel(value = "DateSetElementRuleDTO", description = "数据校验字段规则")
public class DateSetElementRuleDTO {
    @ApiModelProperty(value = "字段id")
    private Long elementId;
    @ApiModelProperty(value = "字段名称")
    private String elementName;
    @ApiModelProperty(value = "字段规则列表")
    private List<String> ruleCodes;
}
