package com.hengyunsoft.platform.ops.servicedto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AssistantDTO", description = "协助人")
public class AssistantDTO {
    /**
     * 协助人id
     */
	@ApiModelProperty(value = "协助人id")
    private Long id;
    /**
     * 协助人姓名
     */
    @ApiModelProperty(value = "协助人姓名")
    private String name;
}
