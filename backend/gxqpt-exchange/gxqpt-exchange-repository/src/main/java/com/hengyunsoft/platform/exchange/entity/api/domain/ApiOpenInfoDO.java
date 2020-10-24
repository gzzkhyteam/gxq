package com.hengyunsoft.platform.exchange.entity.api.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.entity.api.domain
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/5/9
 * 修改内容：
 */
@Data
public class ApiOpenInfoDO  {
    @ApiModelProperty(value = "期限")
    private Date limitTime;
    @ApiModelProperty(value = "api Id")
    private Long apiId;
    @ApiModelProperty(value = "期限天数")
    private Integer dataTerm;
    @ApiModelProperty(value = "数据集Id")
    private Long setId;
    @ApiModelProperty(value = "表名")
    private String tableName;
    @ApiModelProperty(value = "调用单位Id")
    private String callUnitId;
   @ApiModelProperty(value = "调用单位Id")
    private Integer dataFmat;

}
