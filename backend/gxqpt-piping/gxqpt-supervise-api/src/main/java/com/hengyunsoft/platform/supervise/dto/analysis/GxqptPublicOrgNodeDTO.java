package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptPublicOrgNode", description = "根据id用于组织机构节点name替换")
public class GxqptPublicOrgNodeDTO {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "名称")
    private String name;
}
