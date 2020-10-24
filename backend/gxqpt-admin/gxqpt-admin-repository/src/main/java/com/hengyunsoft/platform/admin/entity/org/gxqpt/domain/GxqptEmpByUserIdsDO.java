package com.hengyunsoft.platform.admin.entity.org.gxqpt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "GxqptEmpByUserIds", description = "根据用户id集合模糊查询人员信息")
public class GxqptEmpByUserIdsDO {
    @ApiModelProperty(value = "用户集合")
    private List<Long> userIds;
    @ApiModelProperty(value = "姓名模糊")
    private String name;
    @ApiModelProperty(value = "登录账号模糊")
    private String nickname;
    @ApiModelProperty(value = "手机模糊")
    private String phone;
    @ApiModelProperty(value = "办公电话模糊")
    private String officetel;
    @ApiModelProperty(value = "部门名模糊")
    private String maindeptname;
}
