package com.hengyunsoft.platform.ops.servicedto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tianai
 * @createTime 2018-07-16
 */
@Data
@ApiModel(value = "ServiceManagePageReq", description = "应用升级分页查询")
public class ServiceManagePageReqDTO implements Serializable{
    @ApiModelProperty(value = "服务类别" ,required = false)
    private String serviceType;

    @ApiModelProperty(value = "开始时间" ,required = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;
    @ApiModelProperty(value = "截止时间",required = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    @ApiModelProperty(value = "最小评分")
    private Long startScore;

    @ApiModelProperty(value = "最大评分")
    private Long endScore;
    @ApiModelProperty(value = "状态:1未处理，2已驳回,3已同意4已完结")
    private Integer status;
    @ApiModelProperty(value = "申请人")
    private String applyUser;
    @ApiModelProperty(value = "申请单位" ,required = false)
    private String applyOrg;

    @ApiModelProperty(value = "申请编号" ,required = false)
    private String applyCode;
}

