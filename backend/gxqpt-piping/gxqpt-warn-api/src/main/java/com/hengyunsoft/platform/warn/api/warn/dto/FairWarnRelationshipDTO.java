package com.hengyunsoft.platform.warn.api.warn.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
public class FairWarnRelationshipDTO {

	@ApiModelProperty(value = "部门产生的预警")
	private List<FairDepartmentDTO> warn;	
	@ApiModelProperty(value = "部门使用的应用")
	private List<FairDepartmentAppDTO> apps;
	@ApiModelProperty(value = "部门使用应用产生的预警")
	private List<FairAppWarnDTO> appWarn;
	public List<FairDepartmentDTO> getWarn() {
		return warn;
	}
	public void setWarn(List<FairDepartmentDTO> warn) {
		this.warn = warn;
	}
	public List<FairDepartmentAppDTO> getApps() {
		return apps;
	}
	public void setApps(List<FairDepartmentAppDTO> apps) {
		this.apps = apps;
	}
	public List<FairAppWarnDTO> getAppWarn() {
		return appWarn;
	}
	public void setAppWarn(List<FairAppWarnDTO> appWarn) {
		this.appWarn = appWarn;
	}	
}
