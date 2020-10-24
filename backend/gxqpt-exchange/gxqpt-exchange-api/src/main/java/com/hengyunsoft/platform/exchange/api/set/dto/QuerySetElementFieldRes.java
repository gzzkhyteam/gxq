package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：查询数据集现有的子段返回
 * 修改人：gbl
 * 修改时间：2018/9/14
 * 修改内容：
 */
@Data
@ApiModel(value = "查询数据集现有的子段返回", description = "查询数据集现有的子段返回")
public class QuerySetElementFieldRes {
    @ApiModelProperty(value = "数据集id")
    private Long setId;
    @ApiModelProperty(value = "创建数据集方式:1,选择字段;2,sql查询")
    private Integer setMode;
    @ApiModelProperty(value = "字段列表")
    private List<DataSetElementDTO> fields;
    @ApiModelProperty(value = "在数据源的表名")
    private String tableCode;

}
