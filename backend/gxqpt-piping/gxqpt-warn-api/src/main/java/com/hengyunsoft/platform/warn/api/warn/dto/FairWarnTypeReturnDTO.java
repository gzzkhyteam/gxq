package com.hengyunsoft.platform.warn.api.warn.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FairWarnTypeReturnDTO {
	//预警类型
	@ApiModelProperty(value = "应用名称")
	private String appName;
	//各个状态的数量
	@ApiModelProperty(value = "各个类型的数量")
	private List<FairWarnTypeDTO> list;
	
	@ApiModelProperty(value = "应用名称集合")
	private List<String> appNames;
	@ApiModelProperty(value = "类型名称集合")
	private List<String> types;
	@ApiModelProperty(value = "对应数据集合")
	private List<Integer> counts;
}
