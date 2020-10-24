package com.hengyunsoft.platform.exchange.api.directory.dto.directory;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tianai
 * @createTime 2018-05-2
 */
@Data
@ApiModel(value = "DataDirectoryPageReqAudit", description = "数据目录分页查询")
public class DataDirectoryPageReqAuditDTO implements Serializable {

    @ApiModelProperty(value = "单位id" ,required = false)
    private String unitId;
    @ApiModelProperty(value = "状态" ,required = false)
    private Integer status;
    @ApiModelProperty(value = "开始时间" ,required = false)
    private Date  startTime;
    @ApiModelProperty(value = "截止时间",required = false)
    private Date endTime;
}
