package com.hengyunsoft.platform.admin.api.core.dto.emp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptEmpEmailLike", description = "邮件系统专用人员模糊查询入参")
public class GxqptEmpEmailLikeReqDTO {
    @ApiModelProperty(value = "部门id")
    private String dpmId;
    @ApiModelProperty(value = "关键词:可以是账号，可以使人员名")
    private String keyWord;
}
