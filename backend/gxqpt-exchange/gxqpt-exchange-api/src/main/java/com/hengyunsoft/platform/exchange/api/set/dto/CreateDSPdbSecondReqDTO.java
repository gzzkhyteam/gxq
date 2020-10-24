package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建数据库读取类型数据集第二步
 * 修改人：gbl
 * 修改时间：2018/4/22
 * 修改内容：新增
 */
@Data
@ApiModel(value = " CreateDataSetParamDatabase", description = "创建数据库类型数据集第二步")
public class CreateDSPdbSecondReqDTO {
    @ApiModelProperty(value = "编辑类型,1新增，2编辑，3详情")
    private Integer editType;

    @ApiModelProperty(value = "数据集id")
    private Long id;

    @ApiModelProperty(value = "创建数据集方式:1,选择字段;2,sql查询")
    private Integer setMode;

    @ApiModelProperty(value = "表名标识")
    private String tableCode;

    @ApiModelProperty(value = "选择返回的字段")
    private List<DataSetElementDTO> resultFileName;

    @ApiModelProperty(value = "SQL语句")
    private String sqlCode;
}
