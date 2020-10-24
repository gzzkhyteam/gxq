package com.hengyunsoft.platform.exchange.api.set.dto;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：动态数据集列表Dto
 * 修改人：gbl
 * 修改时间：2018/4/22
 * 修改内容：新增
 */
@Data
@ApiModel(value = " DataSetData", description = "动态数据集列表Dto")
public class DataSetDataDto {

    @ApiModelProperty(value = "标题")
    private List<DataSetElementDTO> fieldName;

    @ApiModelProperty(value = "行数据")
    private PageInfo<Object> dataList;

    @ApiModelProperty(value = "每个字段的规则")
    private List<DateSetElementRuleDTO> eles;

}
