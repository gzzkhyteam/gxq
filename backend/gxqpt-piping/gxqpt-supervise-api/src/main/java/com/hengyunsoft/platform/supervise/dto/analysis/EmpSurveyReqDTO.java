package com.hengyunsoft.platform.supervise.dto.analysis;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "EmpSurveyReq", description = "人员预警概况接收参数")
public class EmpSurveyReqDTO {
	@ApiModelProperty(value = "查询开始时间")
	private Date startTime;
	
	@ApiModelProperty(value = "查询结束时间")
	private Date endTime;
	
    @ApiModelProperty(value = "人员id")
    private List<String> ids;
    
    @ApiModelProperty(value = "部门id")
    private String depId;
}
