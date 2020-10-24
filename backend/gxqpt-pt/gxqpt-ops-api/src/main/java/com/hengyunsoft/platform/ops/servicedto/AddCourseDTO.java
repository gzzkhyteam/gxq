package com.hengyunsoft.platform.ops.servicedto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AddCourseDTO", description = "新增培训课程请求参数")
public class AddCourseDTO {
    @ApiModelProperty(value = "父id")
    private Long pId;
    @ApiModelProperty(value = "级别")
    private Integer level;
    @ApiModelProperty(value = "排序")
    private Integer sort;
    @ApiModelProperty(value = "培训类别")
    private String type;
    @ApiModelProperty(value = "培训名称")
    private String name;
    @ApiModelProperty(value = "培训内容")
    private String context;
}
