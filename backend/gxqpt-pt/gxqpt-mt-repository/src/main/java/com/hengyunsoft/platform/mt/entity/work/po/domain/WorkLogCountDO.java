package com.hengyunsoft.platform.mt.entity.work.po.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WorkLogCountDO implements Serializable{

    @ApiModelProperty(value = "  主键")
    private Long id;

    @ApiModelProperty(value = " 创建时间")
    private Date createDate;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = " 创建人id")
    private Long userId;

    @ApiModelProperty(value = " 所属部门id")
    private String mainDeptId;
    @ApiModelProperty(value = " 所属部门名称")
    private String mainDeptName;

    @ApiModelProperty(value = " 所属职务名称")
    private String mainDutyName;

    @ApiModelProperty(value = " 本职日志数量")
    private Integer count;

    @ApiModelProperty(value = " 照片/头像")
    private String photo;

}
