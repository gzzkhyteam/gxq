package com.hengyunsoft.platform.developer.api.fast.dto.docment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author sunxiaoya
 * @create 2018-05-03
 * @desc 快速应用公文保存
 **/
@Data
@ApiModel(value = "FastAppDocTaskApproveDTO",description = "快速应用公文保存")
public class FastAppDocTaskApproveDTO implements Serializable{
    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * appId
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "appId")
    private String appId;

    /**
     * 处理状态：待办（processing） 已办（finished）
     *
     * @mbggenerated
     */
    //private String handleStatus;

    /**
     * 环节状态：公文登记（register）处室领导审批（directorLeader）
     * 分管领导审批（divisionLeader） 主要领导审批（mainLeader） 办结（finished）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节状态")
    private String linkStatus;

    /**
     * 紧急度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "紧急度")
    private String urgencyDegree;

    /**
     * 标题
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 公文类型：send(发文) receive(收文)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "公文类型：send(发文) receive(收文)")
    private String docType;

    private static final long serialVersionUID = 1L;

}