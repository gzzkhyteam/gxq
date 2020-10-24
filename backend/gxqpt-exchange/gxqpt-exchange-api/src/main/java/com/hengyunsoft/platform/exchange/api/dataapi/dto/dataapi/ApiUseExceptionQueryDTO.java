package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api使用情况查询条件字段
 * 修改人：zhaopengfei
 * 修改时间：2018/5/1
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiUseExceptionQuery", description = "api使用异常情况查询条件")
public class ApiUseExceptionQueryDTO {
    @ApiModelProperty(value = "api ID")
    private String apiId;
    @ApiModelProperty(value = "异常情况")
    private String failLog;
    @ApiModelProperty(value = "异常时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date callDate;
    @ApiModelProperty(value = "处理状态(1,已处理；2，未处理，3、已忽略)")
    private Integer hdleState;
}
