package com.hengyunsoft.platform.supervise.dto.analysis;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "OrgSurveyBackResDTO", description = "单位预警类别返回参数")
public class OrgSurveyBackResDTO {
	@ApiModelProperty(value = "单位名称")
	private String name;
	
    @ApiModelProperty(value = "单位id")
    private String id;
    
    @ApiModelProperty(value = "预警数量")
    private Map<String,Object> count;
}
