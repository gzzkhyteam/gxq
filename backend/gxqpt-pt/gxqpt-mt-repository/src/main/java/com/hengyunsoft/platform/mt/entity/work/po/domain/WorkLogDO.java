package com.hengyunsoft.platform.mt.entity.work.po.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WorkLogDO implements Serializable{

    @ApiModelProperty(value = "  主键")
    private Long id;

    @ApiModelProperty(value = " 创建时间")
    private Date createDate;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = " 所属单位id")
    private String mainOrgId;

    @ApiModelProperty(value = " 所属部门名称")
    private String mainDeptName;

    @ApiModelProperty(value = " 所属职务名称")
    private String mainDutyName;
}
