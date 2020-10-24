package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptEmpTreeBySystem",  description = "根据体系做单位部门人员树的保存实体")
public class GxqptEmpTreeBySystemDTO {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "人员名称")
    private String name;
    @ApiModelProperty(value = "所属单位id")
    private String mainorgid;
    @ApiModelProperty(value = "所属部门id")
    private String maindeptid;
    @ApiModelProperty(value = "体系编码")
    private String systemCode;
    /**
     * 登录账号
     */
    @ApiModelProperty(value = "登录账号")
    private String nickname;
}
