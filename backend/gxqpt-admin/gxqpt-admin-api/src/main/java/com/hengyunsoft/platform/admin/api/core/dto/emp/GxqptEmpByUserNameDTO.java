package com.hengyunsoft.platform.admin.api.core.dto.emp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "GxqptEmpByUserNameDTO", description = "模糊查询人员信息")
public class GxqptEmpByUserNameDTO {
    @ApiModelProperty(value = "姓名模糊")
    private String name;
    @ApiModelProperty(value = "部门名模糊")
    private String maindeptname;
    @ApiModelProperty(value = "用户名集合")
    private List<String> userIds;
    @ApiModelProperty(value = "页码")
    private Integer pageNo;
    @ApiModelProperty(value = "每页条数")
    private Integer pageSize;
}
