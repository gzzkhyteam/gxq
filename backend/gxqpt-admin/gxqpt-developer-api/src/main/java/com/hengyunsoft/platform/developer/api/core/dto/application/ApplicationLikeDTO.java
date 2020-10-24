package com.hengyunsoft.platform.developer.api.core.dto.application;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ApplicationLikeDTO {
    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "名称")
    private String name;
}
