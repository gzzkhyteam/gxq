package com.hengyunsoft.platform.supervise.dto.analysis;

import java.util.Date;
import java.util.List;
import java.util.Set;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SurveyReqDTO {
	@ApiModelProperty(value = "查询开始时间")
	private Date startTime;
	
	@ApiModelProperty(value = "查询结束时间")
	private Date endTime;
	
    @ApiModelProperty(value = "单位/部门/人员/应用id集合")
    private List<String> ids;
    
    @ApiModelProperty(value = "预警类型id")
    private Set<Long> typeIds;
    
    @ApiModelProperty(value = "部门id，人员预警统计时传")
    private String depId;
}
