package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wt
 * @create 2018-05-08
 * @desc 签到/退信息独立列表
 **/
@Data
@ApiModel(value = "AttenceListDTO",description = "签到/退信息独立列表")
public class AttenceListDTO implements Serializable{

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private String id;

    /**
     * 签到时间
     */
    @ApiModelProperty(value = "签到时间")
    private Date signTime;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 签到图片Id，逗号分隔
     */
    @ApiModelProperty(value = "签到图片Id，逗号分隔")
    private String picture;

    /**
     * 抄送部门ID拼接字符串
     */
    @ApiModelProperty(value = "抄送部门ID拼接字符串")
    private String deptId;

    /**
     * 抄送人员 ID逗号分隔字符串
     */
    @ApiModelProperty(value = "抄送人员 ID逗号分隔字符串")
    private String empId;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private Double latitude;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private Double longitude;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String address;

    /**
     * 是否自动签到（0：否，1:是）
     */
    @ApiModelProperty(value = "是否自动签到（0：否，1:是）")
    private Integer autoSign;

    /**
     * 签到用户ID
     */
    @ApiModelProperty(value = "签到用户ID")
    private String userid;

    /**
     * 0：签到，1： 签退
     */
    @ApiModelProperty(value = "0：签到，1： 签退")
    private Integer signType;

    /**
     * 操作类型（0:内勤，1:外勤）
     */
    @ApiModelProperty(value = "操作类型（0:内勤，1:外勤）")
    private Integer handleType;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 迟到或早退时长
     */
    @ApiModelProperty(value = "迟到或早退时长")
    private float hours;



    private static final long serialVersionUID = 1L;

}