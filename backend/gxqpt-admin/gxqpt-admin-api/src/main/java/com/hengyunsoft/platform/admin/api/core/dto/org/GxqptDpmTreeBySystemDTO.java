package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "GxqptDpmTreeBySystem",  description = "根据体系做单位部门树的保存实体")
public class GxqptDpmTreeBySystemDTO {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "部门名称")
    private String name;
    @ApiModelProperty(value = "所属单位id")
    private String orgId;
    @ApiModelProperty(value = "体系编码")
    private String systemCode;
    @ApiModelProperty(value = "该部门下人员集合")
    private List<GxqptEmpTreeBySystemDTO> list = new ArrayList<>();
}
