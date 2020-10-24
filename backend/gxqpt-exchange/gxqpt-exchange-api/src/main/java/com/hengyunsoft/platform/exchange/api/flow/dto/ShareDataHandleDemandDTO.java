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
 * 描述：需求处理DTO
 * 修改人：zhaopengfei
 * 修改时间：2018/4/25
 * 修改内容：
 */
@Data
public class ShareDataHandleDemandDTO extends HandleDTO {
    @ApiModelProperty(value = "预计封装API时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date estimateTime;
}

