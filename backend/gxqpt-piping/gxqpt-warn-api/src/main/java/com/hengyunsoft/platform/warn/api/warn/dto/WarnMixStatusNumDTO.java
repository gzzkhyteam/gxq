package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "WarnMixStatusNumDTO", description = "获取个人预警混合状态数量,确认,处理DTO")
public class WarnMixStatusNumDTO {

	/**
	 * 未确认预警数量
	 */
	@ApiModelProperty(value = "未确认预警数量")
	private int unConfirmedNum;

	/**
	 * 已确认预警数量
	 */
	@ApiModelProperty(value = "已确认预警数量")
	private int confirmedNum;

	/**
	 * 已处理预警数量
	 */
	@ApiModelProperty(value = "已处理预警数量")
	private int handledNum;

	/**
	 * 预警处理平均时长
	 */
	@ApiModelProperty(value = "预警处理平均时长")
	private Double avgHandleTimeNum;

}
