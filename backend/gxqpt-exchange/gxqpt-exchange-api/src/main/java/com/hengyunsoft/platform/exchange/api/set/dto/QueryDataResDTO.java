package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：根据目录id查询数据请求
 * 修改人：gbl
 * 修改时间：2018/4/24
 * 修改内容：
 */
@Data
@ApiModel(value = "QueryDataReq", description = "根据目录id查询数据")
public class QueryDataResDTO {
    @ApiModelProperty(value = "总条数")
    private Integer records;
    @ApiModelProperty(value = "列名称")//目录字段名称
    private List<DataSetElementDTO> fileds;
    @ApiModelProperty(value = "返回的行数据")
    private List<List<Object>> rowData;
}
