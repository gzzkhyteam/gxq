package com.hengyunsoft.platform.ops.servicedto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "UpdateCourseDTO", description = "修改培训课程")
public class UpdateCourseDTO {
	@ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "培训类型")
    private String type;
    @ApiModelProperty(value = "培训名称")
    private String name;
    @ApiModelProperty(value = "培训内容")
    private String context;   
}
