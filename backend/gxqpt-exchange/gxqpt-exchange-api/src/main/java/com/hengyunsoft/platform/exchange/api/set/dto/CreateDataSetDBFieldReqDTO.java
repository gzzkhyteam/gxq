package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建数据库类型的数据集，选择字段方式创建
 * 修改人：gbl
 * 修改时间：2018/4/23
 * 修改内容：
 */
@Data
@ApiModel(value = " CreateDataSetDBFile", description = "创建数据库类型的数据集，选择字段方式创建")
public class CreateDataSetDBFieldReqDTO extends CreateDSPdbSecondReqDTO {
    @ApiModelProperty(value = "参数字段")
    private List<FieldParamDTO> paramFileds;

    @ApiModelProperty(value = "选择管理的目录")
    private List<RelatedDirectoryDTO> directory;

    @ApiModelProperty(value = "SQL语句")
    private String sqlCode;


}
