package com.hengyunsoft.platform.exchange.api.directory.dto.directory;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tianai
 * @createTime 2018-05-2
 */
@Data
@ApiModel(value = "DataDirectoryAudit", description = "待审核目录分页查询")
public class DataDirectoryAuditDTO implements Serializable {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "单位id")
    private String unitId;
    @ApiModelProperty(value = "单位名称")
    private String unitName;
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    @ApiModelProperty(value = "申请人Id")
    private Long userId;
    @ApiModelProperty(value = "申请人名称")
    private String  userName;
    @ApiModelProperty(value = "流程待办任务id")
    private String taskId;
    @ApiModelProperty(value = "审核id")
    private Long auditId;
    @ApiModelProperty(value = "申请理由")
    private String applicationReasons;
    @ApiModelProperty(value = "申请编号")
    private String applyCode;
    @ApiModelProperty(value = "操作类型")
    private String optType;
    @ApiModelProperty(value = "是否平台管理员")
    private Integer isPtadmin;//1是
    @ApiModelProperty(value = "状态")
    private Integer status;//审批状态:1,未发布；2，审批中；3，驳回；4，已发布；
    @ApiModelProperty(value = "任务开始时间")
    private Date optTime;
}
