package com.hengyunsoft.platform.ops.entity.train.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TrainAdminPageReqDTO", description = "培训审核分页列表请求参数")
public class TrainAdminPageReqDO extends TrainPageReqDO{

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "提交单位")
    private String company;
    @ApiModelProperty(value = "提交人")
    private String person;
    @ApiModelProperty(value = "处理页面标示，0=审核，1=处理")
    private Integer handle;
}
