package com.hengyunsoft.platform.exchange.api.flow.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.api.flow.dto
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述:api申请查询条件Dto
 * 修改人：zhaopengfei
 * 修改时间：2018/4/25
 * 修改内容：
 */
@Data
public class ShareFLowApiConditionDTO {
    @ApiModelProperty(value = "API名称")
    private String apiName;
    @ApiModelProperty(value = "目录名称")
    private String dirName;
    @ApiModelProperty(value = "目录Id")
    private Long dirId;
    @ApiModelProperty(value = "申请类型(1:API延续申请，2：目录新增API，3：已封装API申请)")
    private Integer applyType;
    @ApiModelProperty(value = "审批状态(0：全部，1:通过，2：驳回)")
    private Integer handleStatus;
    @ApiModelProperty(value = "申请开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startTime;
    @ApiModelProperty(value = "申请结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endTime;
}
