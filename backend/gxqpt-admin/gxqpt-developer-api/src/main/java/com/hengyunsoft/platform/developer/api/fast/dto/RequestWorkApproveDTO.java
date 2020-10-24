package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wt
 * @create 2018-05-08
 * @desc 审批列表
 **/
@Data
@ApiModel(value = "RequestWorkApproveDTO",description = "审批列表入参")
public class RequestWorkApproveDTO implements Serializable{

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用ID")
    private String appId;
    /**
     * 类型(0 全部 1 我发起的 2 待我审批 )
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "类型(0 全部 1 我发起的 2 待我审批 )")
    private String approvalType;


    /**
     * 开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开始时间")
    private String startDate;

    /**
     * 结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "结束时间")
    private String endDate;



    private static final long serialVersionUID = 1L;

}