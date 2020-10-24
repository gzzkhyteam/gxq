package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建数据库数据集第一步提交数据
 * 修改人：gbl
 * 修改时间：2018/4/24
 * 修改内容：
 */
@Data
@ApiModel(value = "CreateDSPdbFirst", description = "创建数据库数据集第一不提交数据")
public class CreateDSPdbFirstReqDTO extends  CreateDataSetParamDTO{
    @ApiModelProperty(value = " 数据源id")
    private Long dbId;

    @ApiModelProperty(value = "更新方式:1,全量；2，增量")
    private Integer updateType;
}
