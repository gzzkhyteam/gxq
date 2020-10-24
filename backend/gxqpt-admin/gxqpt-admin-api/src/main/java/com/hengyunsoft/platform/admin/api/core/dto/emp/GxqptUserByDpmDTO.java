package com.hengyunsoft.platform.admin.api.core.dto.emp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptUserByDpm", description = "部门查询包括身份用户返回实体")
public class GxqptUserByDpmDTO {
    @ApiModelProperty(value = "人员id")
    private String id;
    @ApiModelProperty(value = "人员名称")
    private String name;
    @ApiModelProperty(value = "体系")
    private String systemCode;
}
