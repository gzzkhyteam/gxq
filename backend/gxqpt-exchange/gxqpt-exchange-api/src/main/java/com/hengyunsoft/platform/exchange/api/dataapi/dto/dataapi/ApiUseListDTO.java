package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api使用情况列表返回字段
 * 修改人：zhaopengfei
 * 修改时间：2018/5/1
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiUseList", description = "API基础信息")
public class ApiUseListDTO {
    @ApiModelProperty(value = "调用情况Id")
    private Long id;
    @ApiModelProperty(value = "调用Api单位")
    private String orgName;

    @ApiModelProperty(value = "授权期限")
    private Date limitTime;

    @ApiModelProperty(value = "调用时间")
    private Date visitTime;

    @ApiModelProperty(value = "交换数据量")
    private Integer dataCount;

    @ApiModelProperty(value = "调用时长")
    private Float rsponseTime;
}
