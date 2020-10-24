package com.hengyunsoft.platform.ops.faultdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tianai
 * @createTime 2018-07-23
 */
@Data
@ApiModel(value = "FaultManagePageReqDTO", description = "故障管理分页查询")
public class FaultManagePageReqDTO implements Serializable{

    @ApiModelProperty(value = "故障名称" ,required = false)
    private String faultName;

    @ApiModelProperty(value = "故障类别" ,required = false)
    private String faultType;

    @ApiModelProperty(value = "故障级别" ,required = false)
    private String faultLevel;

    @ApiModelProperty(value = "开始时间" ,required = false)
    private Date startTime;
    @ApiModelProperty(value = "截止时间",required = false)
    private Date endTime;

    @ApiModelProperty(value = "处理状态")
    private Integer status;

    @ApiModelProperty(value = "是否属实")
    private String isTrue;

    @ApiModelProperty(value = "故障主机")
    private String faultHost;

     @ApiModelProperty(value = "系统名称")
    private String systemId;
}
