package com.hengyunsoft.platform.admin.api.core.dto.emp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptEmpByDpm", description = "部门查询包括身份人员返回实体")
public class GxqptEmpByDpmDTO {
    @ApiModelProperty(value = "人员id")
    private String id;
    @ApiModelProperty(value = "人员名称")
    private String name;
    @ApiModelProperty(value = "体系")
    private String systemCode;
}
