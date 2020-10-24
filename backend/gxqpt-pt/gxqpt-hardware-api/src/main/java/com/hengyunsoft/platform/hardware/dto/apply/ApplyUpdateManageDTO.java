package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "ApplyManageDTO", description = "申请管理")
public class ApplyUpdateManageDTO extends ApplyManageDTO {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

}
