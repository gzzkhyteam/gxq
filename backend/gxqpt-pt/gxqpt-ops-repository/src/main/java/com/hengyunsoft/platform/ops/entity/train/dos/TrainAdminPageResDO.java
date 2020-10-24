package com.hengyunsoft.platform.ops.entity.train.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TrainAdminPageResDO", description = "培训审核分页列表返回参数")
public class TrainAdminPageResDO extends TrainPageResDO{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "提交单位")
    private String company;
    @ApiModelProperty(value = "提交人")
    private String person;
    @ApiModelProperty(value = "培训人Id")
    private String personId;
}
