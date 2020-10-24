package com.hengyunsoft.platform.ops.applicationdto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tianai
 * @createTime 2018-07-16
 */
@Data
@ApiModel(value = "ApplicationPageReq", description = "应用升级分页查询")
public class ApplicationPageReqDTO implements Serializable{

    @ApiModelProperty(value = "应用id" ,required = true)
    private String appId;
    @ApiModelProperty(value = "版本号" ,required = false)
    private String versionNumber;

    @ApiModelProperty(value = "开始时间" ,required = false)
    private Date startTime;

    @ApiModelProperty(value = "截止时间",required = false)
    private Date endTime;
}
