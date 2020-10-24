package com.hengyunsoft.platform.exchange.api.directory.dto.directory;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tianai
 * @createTime 2018-04-21
 */
@Data
@ApiModel(value = "DataDirectoryPageReq", description = "数据目录分页查询")
public class DataDirectoryPageReqDTO implements Serializable {
    @ApiModelProperty(value = "状态" ,required = false)
    private Integer status;
    @ApiModelProperty(value = "开始时间" ,required = false)
    private String startTime;
    @ApiModelProperty(value = "截止时间",required = false)
    private String endTime;
}
