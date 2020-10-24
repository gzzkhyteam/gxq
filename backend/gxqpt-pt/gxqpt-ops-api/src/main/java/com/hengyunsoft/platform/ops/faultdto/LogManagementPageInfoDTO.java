package com.hengyunsoft.platform.ops.faultdto;

import com.hengyunsoft.platform.ops.operationfiledto.OperationFileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * 表名：b_yw_log_management
 *
 * @mbggenerated do_not_delete_during_merge
 * addModelClassComment 242 
 */
@Data
@ApiModel(value = "LogManagementPageDTO", description = "日志管理")
public class LogManagementPageInfoDTO implements Serializable {

    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "编号")
    private String code;
    @ApiModelProperty(value = "日志类别")
    private String logType;
    @ApiModelProperty(value = "日志记录")
    private String logRecord;
    @ApiModelProperty(value = "故障级别")
    private String faultLevel;
    @ApiModelProperty(value = "故障分类")
    private String faultClassification;
    @ApiModelProperty(value = "处理人")
    private Long dealUser;
    @ApiModelProperty(value = "处理时间")
    private Date dealTime;
    @ApiModelProperty(value = "附件")
    private List<OperationFileDTO> files;
    @ApiModelProperty(value = "处理人姓名")
    private String dealUserName;


}