package com.hengyunsoft.platform.supervise.dto.analysis;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "SurveyRecDTO", description = "预警概况接收参数")
public class SurveyRecDTO {
	@ApiModelProperty(value = "查询年份")
	private String year;
	
    @ApiModelProperty(value = "单位/部门/人员/应用id集合")
    private List<String> ids;
    
    @ApiModelProperty(value = "部门id，人员预警统计时传")
    private String depId;
}
