package com.hengyunsoft.platform.developer.api.fast.dto.docment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunxiaoya
 * @create 2018-05-03
 * @desc 快速应用公文拟办保存返回
 **/
@Data
@ApiModel(value = "FastAppDocExtraAdviceRetDTO",description = "快速应用公文拟办保存返回")
public class FastAppDocExtraAdviceRetDTO implements Serializable{
    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * 任务id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "任务id")
    private Long taskId;

    /**
     * 收发文类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "收发文类型")
    private String taskType;

    /**
     * 任务名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "任务名称")
    private String taskName;

    /**
     * 牵头领导
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "牵头领导")
    private String leadName;

    /**
     * 收文处理状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "收文处理状态")
    private Long leadId;

    /**
     * 配合领导
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "配合领导")
    private String coordinationName;

    /**
     * 配合领导id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "配合领导id")
    private Long coordinationId;

    /**
     * 承办处室
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "承办处室")
    private String undertakeRoom;

    /**
     * 配合处室
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "配合处室")
    private String coordinationRoom;

    /**
     * 代理
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "代理")
    private String agent;

    /**
     * 紧急程度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "紧急程度")
    private String urgencyDegree;

    /**
     * 完成时限
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "完成时限")
    private Date finishTimeLimit;

    /**
     * 内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 附件地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "附件地址")
    private String attachmentUrl;

    /**
     * 描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "描述")
    private String desc;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人id")
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

}