package com.hengyunsoft.platform.admin.api.core.dto.dpm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptDpmEdit", description = "编辑实体")
public class GxqptDpmEditDTO extends GxqptDpmSaveDTO{

    /**
     * 编辑部门id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编辑部门id")
    private String id;
}
