package com.hengyunsoft.platform.ops.servicedto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TrainTypeDTO", description = "培训类型")
public class TrainTypeDTO {
	@ApiModelProperty(value = "培训类别")
	private String type;
	@ApiModelProperty(value = "培训类别id")
	private List<String> names;
}
