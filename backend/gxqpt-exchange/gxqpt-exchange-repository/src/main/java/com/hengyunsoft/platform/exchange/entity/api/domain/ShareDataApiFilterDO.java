package com.hengyunsoft.platform.exchange.entity.api.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * com.hengyunsoft.platform.exchange.entity.api.domain
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/4/24
 * 修改内容：
 */
@Data
public class ShareDataApiFilterDO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "字段名称")
    private String fieldName;
    @ApiModelProperty(value = "字段类型")
    private String fieldType;
    @ApiModelProperty(value = "字段描述")
    private String desc;
    @ApiModelProperty(value = "字段编码")
    private String fieldCode;
    @ApiModelProperty(value = "筛选规则(1,大于；2，小于；3，等于；4，模糊)")
    private String scrRule;
    @ApiModelProperty(value = "筛选值")
    private String scrValue;
}
