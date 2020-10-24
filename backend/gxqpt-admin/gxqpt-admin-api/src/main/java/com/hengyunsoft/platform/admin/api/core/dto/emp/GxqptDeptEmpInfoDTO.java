package com.hengyunsoft.platform.admin.api.core.dto.emp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "GxqptDeptEmpInfoDTO", description = "部门信息")
public class GxqptDeptEmpInfoDTO {
    @ApiModelProperty(value = "部门名称")
    private String name;
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "部门下人员信息")
    private List<GxqptEmpPhoneDTO> empList;
    @ApiModelProperty(value = "类型org单位，dept部门")
    private String type = "dept";
}
