package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "WarnScaleCountDTO", description = "预警月份概况接收参数")
public class WarnScaleCountDTO {
	//待处理数量
	@ApiModelProperty(value = "待处理数量")
	private Integer pending;
	//新增数量
	@ApiModelProperty(value = "新增数量")
	private Integer newCome;	
	//已处理数量
	@ApiModelProperty(value = "已处理数量")
	private Integer handled;
	//年份、月份
	@ApiModelProperty(value = "年份、月份")
	private String month;
	//平均确认时长
	@ApiModelProperty(value = "平均确认时长")
	private String avgConfirmTime;
	//平均处理时长
	@ApiModelProperty(value = "平均处理时长")
	private String avgHandleTime;
}
