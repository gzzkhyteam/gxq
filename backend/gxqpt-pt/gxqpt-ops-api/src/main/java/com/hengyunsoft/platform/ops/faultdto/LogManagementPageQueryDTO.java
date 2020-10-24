package com.hengyunsoft.platform.ops.faultdto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 *
 * 表名：b_yw_log_management
 *
 * @mbggenerated do_not_delete_during_merge
 * addModelClassComment 242 
 */
@Data
@ApiModel(value = "LogManagementPageQueryDTO", description = "日志管理查询参数")
public class LogManagementPageQueryDTO implements Serializable {

    @ApiModelProperty(value = "日志类别")
    @Length(max=20)
    private String logType;

    @ApiModelProperty(value = "故障分类")
    @Length(max=20)
    private String faultClassification;


}