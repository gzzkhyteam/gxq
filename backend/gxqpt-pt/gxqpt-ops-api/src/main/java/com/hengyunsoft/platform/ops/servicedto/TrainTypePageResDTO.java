package com.hengyunsoft.platform.ops.servicedto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TrainTypePageResDTO", description = "培训课程目录分页列表返回参数")
public class TrainTypePageResDTO {
    @ApiModelProperty(value = "培训类型id")
    private Long id;
	@ApiModelProperty(value = "培训类别")
	private String type;
	@ApiModelProperty(value = "培训名称")
	private String name;
	@ApiModelProperty(value = "培训内容")
	private String context;
}
