package com.hengyunsoft.platform.search.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.search.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：字段分析结果返回
 * 修改人：gbl
 * 修改时间：2018/4/13
 * 修改内容：新增
 */
@Data
@ApiModel(value = "AnalysisRes", description = "字段分析结果返回")
public class AnalysisResDTO {
    @ApiModelProperty(value = "索引分析结果")
    private String indexStr;
    @ApiModelProperty(value = "查询分析结果")
    private String queryStr;

}
