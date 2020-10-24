package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述： 创建api类型的数据集第一步提交
 * 修改人：gbl
 * 修改时间：2018/4/22
 * 修改内容：
 */
@Data
@ApiModel(value = "CreateDPApiFirstReq", description = "创建api类型的数据集第一步提交")
public class CreateDPApiFirstReqDTO extends  CreateDataSetParamDTO{
    @ApiModelProperty(value = "API地址")
    private String apiUrl;

    @ApiModelProperty(value = " API数据类型:1,jason;2,xml")
    private Integer apiDataType;

    @ApiModelProperty(value = "更新方式:1,全量；2，增量")
    private Integer updateType;
}
