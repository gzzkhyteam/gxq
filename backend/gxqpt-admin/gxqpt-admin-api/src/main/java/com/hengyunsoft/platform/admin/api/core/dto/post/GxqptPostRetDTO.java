package com.hengyunsoft.platform.admin.api.core.dto.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "GxqptPost", description = "岗位信息")
public class GxqptPostRetDTO extends GxqptPostSaveDTO implements Serializable {
    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 删除标记
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "删除标记")
    private String isdelete;

}
