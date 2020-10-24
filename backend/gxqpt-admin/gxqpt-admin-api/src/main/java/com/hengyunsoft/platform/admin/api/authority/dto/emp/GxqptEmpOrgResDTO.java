package com.hengyunsoft.platform.admin.api.authority.dto.emp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptEmpOrgRes", description = "用户人员主单位返回信息")
public class GxqptEmpOrgResDTO {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "主单位id")
    private String mainorgid;
    @ApiModelProperty(value = "主单位名称")
    private String mainorgname;
}
