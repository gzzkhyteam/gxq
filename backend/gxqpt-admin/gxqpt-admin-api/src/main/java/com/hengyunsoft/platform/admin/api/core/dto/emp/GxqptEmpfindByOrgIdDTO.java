package com.hengyunsoft.platform.admin.api.core.dto.emp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "GxqptEmpfindByOrgId", description = "全体系根据单位id查询人员(带身份)")
public class GxqptEmpfindByOrgIdDTO {
    @ApiModelProperty(value = "单位id集合")
    List<String> orgIds;
}
