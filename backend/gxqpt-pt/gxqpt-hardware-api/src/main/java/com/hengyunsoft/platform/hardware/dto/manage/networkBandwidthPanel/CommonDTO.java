package com.hengyunsoft.platform.hardware.dto.manage.networkBandwidthPanel;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "CommonDTO", description = "统计封装实体类")
public class CommonDTO {
	@ApiModelProperty(value = "名称")
	private String name;
	/**
	 * 这个value 实际上就是echarts 条形图中的data  以后会改正
	 * 如：
	 * {
	 * 	name:'邮件营销',// 名称
	 * 	type:'line',
	 * 	stack: '总量',
	 * 	data:[120, 132, 101, 134, 90, 230, 210] //value
	 * }
	 */
	@ApiModelProperty(value = "值")
	private List<Integer> value;
}
