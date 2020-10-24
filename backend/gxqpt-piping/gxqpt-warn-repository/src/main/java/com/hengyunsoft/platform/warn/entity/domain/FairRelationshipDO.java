package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "FairRelationshipDO", description = "预警信息")
public class FairRelationshipDO {
	//部门id	
	@ApiModelProperty(value = "部门id")
	private String departmentId;
	//部门名称
	@ApiModelProperty(value = "部门名称")
	private String department;
	//应用id
	@ApiModelProperty(value = "应用id")
	private String appId;
	//应用名称
	@ApiModelProperty(value = "应用名称")
	private String appName;
	//预警级别
	@ApiModelProperty(value = "预警级别数量")
	private Integer count;

	@ApiModelProperty(value = "预警级别")
	private Integer level;

}
