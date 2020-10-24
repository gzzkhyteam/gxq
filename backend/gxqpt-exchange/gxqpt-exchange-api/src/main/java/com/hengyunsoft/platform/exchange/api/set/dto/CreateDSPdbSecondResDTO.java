package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建数据库读取类型数据集第二步返回
 * 修改人：gbl
 * 修改时间：2018/4/24
 * 修改内容：
 */
@Data
@ApiModel(value = "CreateDSPdbSecondRes", description = "创建数据库读取类型数据集第二步返回")
public class CreateDSPdbSecondResDTO {
    @ApiModelProperty(value = "数据集id")
    private long id;

    @ApiModelProperty(value = "字段列表")
    private List<DataSetElementDTO> fieldList;
    @ApiModelProperty(value = "数据源id")
    private Long dbId;

    @ApiModelProperty(value = "表名标识")
    private String tableCode;

}
