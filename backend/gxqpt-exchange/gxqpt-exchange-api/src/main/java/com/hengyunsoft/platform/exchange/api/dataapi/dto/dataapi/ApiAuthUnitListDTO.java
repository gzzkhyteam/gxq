package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api授权单位list
 * 修改人：zhaopengfei
 * 修改时间：2018/4/30
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiAuthUnitList", description = "api授权单位列表")
public class ApiAuthUnitListDTO {
    @ApiModelProperty(value = "共享申请Id")
    private Long id;
    @ApiModelProperty(value = "api名称")
    private String apiName;
    @ApiModelProperty(value = "单位名称")
    private String orgName;
    @ApiModelProperty(value = "申请授权期限")
    private String dateTerm;
    @ApiModelProperty(value = "到期时间")
    private String limitTime;
    @ApiModelProperty(value = "交换数据量")
    private Integer dataNum;
    @ApiModelProperty(value = "调用次数")
    private Integer callNum;
}
