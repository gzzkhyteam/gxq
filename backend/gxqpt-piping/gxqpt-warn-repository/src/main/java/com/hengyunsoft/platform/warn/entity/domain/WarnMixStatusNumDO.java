package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "WarnMixStatusNumDTO", description = "获取个人预警混合状态数量,确认,处理DTO")
public class WarnMixStatusNumDO {

	/**
	 * 未确认预警数量
	 */
	private int unConfirmedNum;

	/**
	 * 已确认预警数量
	 */
	private int confirmedNum;

	/**
	 * 已处理预警数量
	 */
	private int handledNum;

	/**
	 * 预警处理平均时长
	 */
	private Double avgHandleTimeNum;

}
