package com.hengyunsoft.platform.exchange.api.dataapi.dto.demand;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：需求新增dto
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：
 */
@Data
@ApiModel(value = "DemandQuery", description = "需求过滤条件")
public class DemandQueryDTO {
    @ApiModelProperty(value = "处理状态(1,待审批；2，已驳回；3，通过，待封装API；4，已封装API)")
    private Integer status;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endTime;

    @ApiModelProperty(value = "数据提供单位名称")
    private String orgName;

    @ApiModelProperty(value = "申请单位Id")
    private String unitId;
}
