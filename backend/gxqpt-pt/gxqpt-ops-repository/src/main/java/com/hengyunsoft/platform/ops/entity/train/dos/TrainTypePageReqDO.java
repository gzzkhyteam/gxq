package com.hengyunsoft.platform.ops.entity.train.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TrainTypePageReqDO", description = "培训课程目录分页列表请求参数")
public class TrainTypePageReqDO {
	@ApiModelProperty(value = "培训类别")
	private String type;
	@ApiModelProperty(value = "培训名称")
	private String name;
	@ApiModelProperty(value = "培训内容")
	private String context;
}
