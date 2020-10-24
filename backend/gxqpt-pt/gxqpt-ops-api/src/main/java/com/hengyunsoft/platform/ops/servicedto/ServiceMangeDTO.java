package com.hengyunsoft.platform.ops.servicedto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author tianai
 * @createTime 2018-07-17
 */
@Data
public class ServiceMangeDTO implements Serializable{

    @ApiModelProperty(value = "主键")
    private Long id;


    @ApiModelProperty(value = "服务类别")
    private String serviceType;


    @ApiModelProperty(value = "服务对象")
    private String serviceObj;


    @ApiModelProperty(value = "服务分类")
    private String serviceClass;


    @ApiModelProperty(value = "服务名称")
    private String serviceName;


    @ApiModelProperty(value = "服务开始时间")
    private Date startTime;


    @ApiModelProperty(value = "服务结束时间")
    private Date endTime;

    @ApiModelProperty(value = "报告结束时间")
    private Date reportTime;


    @ApiModelProperty(value = "服务过程")
    private String serviceProcess;


    @ApiModelProperty(value = "结果")
    private String result;


    @ApiModelProperty(value = "备注")
    private String remark;


    @ApiModelProperty(value = "申请人")
    private String applyUser;

    @ApiModelProperty(value = "申请单位")
    private String applyOrg;


    @ApiModelProperty(value = "审批意见")
    private String auditOpinion;


    @ApiModelProperty(value = "状态:1未处理，2已驳回,3已同意4已完结")
    private Integer status;


    @ApiModelProperty(value = "服务态度")
    private Long serviceAttitude;


    @ApiModelProperty(value = "服务效率")
    private Long serviceEfficiency;


    @ApiModelProperty(value = "服务评价")
    private Long serviceEvaluation;

    @ApiModelProperty(value = "评分")
    private Long score;

    @ApiModelProperty(value = "服务建议")
    private String serviceAdvice;


    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "主要负责系统")
    private List<ServiceSystemDTO> systemName;

    @ApiModelProperty(value = "处理人")
    private Long dealUser;
    @ApiModelProperty(value = "申请编号" ,required = false)
    private String applyCode;
}
