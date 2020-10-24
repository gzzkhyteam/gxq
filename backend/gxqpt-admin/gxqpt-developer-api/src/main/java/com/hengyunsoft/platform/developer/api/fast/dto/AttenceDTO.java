package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wt
 * @create 2018-05-08
 * @desc 签到/退信息表
 **/
@Data
@ApiModel(value = "AttenceDTO",description = "签到/退信息表")
public class AttenceDTO implements Serializable{
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private String id;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用ID")
    private String appId;

    /**
     * 签到
     */
    @ApiModelProperty(value = "签到")
    private Date inTime;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String inRemark;

    /**
     * 签到图片Id，逗号分隔
     */
    @ApiModelProperty(value = "签到图片地址")
    private String inPicture;

    /**
     * 抄送部门ID拼接字符串
     */
    @ApiModelProperty(value = "抄送部门ID拼接字符串")
    private String inDeptId;

    /**
     * 抄送人员 ID逗号分隔字符串
     */
    @ApiModelProperty(value = "抄送人员 ID逗号分隔字符串")
    private String inEmpId;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private Double inLatitude;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private Double inLongitude;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String inAddress;

    /**
     * 是否自动签到（0：否，1:是）
     */
    @ApiModelProperty(value = "是否自动签到（0：否，1:是）")
    private Integer inAutoSign;

    /**
     * 0：签到，1： 签退
     */
    @ApiModelProperty(value = "0：签到，1： 签退")
    private Integer inSignType;

    /**
     * 操作类型（0:内勤，1:外勤）
     */
    @ApiModelProperty(value = "操作类型（0:内勤，1:外勤）")
    private Integer inHandleType;


    private static final long serialVersionUID = 1L;

}