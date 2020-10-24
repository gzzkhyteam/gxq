package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wt
 * @create 2018-05-08
 * @desc 签到/退信息表
 **/
@Data
@ApiModel(value = "AttenceQueryDTO",description = "签到/退信息表")
public class AttenceQueryDTO implements Serializable{

    @ApiModelProperty(value = "员工id")
    private String empId;//员工id
    @ApiModelProperty(value = "部门编码")
    private String orgCode ; //部门编码
    @ApiModelProperty(value = "职务编码")
    private String postionCode; //职务编码
    @ApiModelProperty(value = "工作日期")
    private Date workDate;//工作日期
    @ApiModelProperty(value = "开始日期")
    private Date startDate;//开始日期
    @ApiModelProperty(value = "结束日期")
    private Date endDate;//结束日期
    @ApiModelProperty(value = "员工姓名")
    private String empName;//员工姓名
    @ApiModelProperty(value = "部门名称")
    private String orgName;//部门名称
    @ApiModelProperty(value = "职务名称")
    private String postName;//职务名称
    @ApiModelProperty(value = "应出勤天数")
    private Integer ycqDay;//应出勤天数
    @ApiModelProperty(value = "正常出勤天数")
    private Integer sjcqDay;//正常出勤天数
    @ApiModelProperty(value = "外勤小时")
    private Float outsideHour;//外勤小时
    @ApiModelProperty(value = "加班小时")
    private Float extraworkHour;//加班小时
    @ApiModelProperty(value = "请假小时")
    private Float leaveHour;//请假小时
    @ApiModelProperty(value = "迟到小时")
    private Float lateHour;//迟到小时
    @ApiModelProperty(value = "早退小时")
    private Float earlyHour;//早退小时
    @ApiModelProperty(value = "旷工小时")
    private Float neglectHour;//旷工小时
    @ApiModelProperty(value = "实际工作小时")
    private Float actualHour;//实际工作小时
    @ApiModelProperty(value = "实际工作小时")
    private Float businessHour;//实际工作小时
    @ApiModelProperty(value = "加班条件 （1：> ,2:=,3:<）")
    private Integer extraworkCondition;//加班条件 （1：> ,2:=,3:<）
    @ApiModelProperty(value = "实际工作条件 （1：> ,2:=,3:<）")
    private Integer actualCondition;//实际工作条件 （1：> ,2:=,3:<）
    @ApiModelProperty(value = "外勤条件 （1：> ,2:=,3:<）")
    private Integer outsideCondition;//外勤条件 （1：> ,2:=,3:<）
    @ApiModelProperty(value = "旷工条件 （1：> ,2:=,3:<）")
    private Integer neglectCondition;//旷工条件 （1：> ,2:=,3:<）
    @ApiModelProperty(value = "迟到条件 （1：> ,2:=,3:<）")
    private Integer lateCondition;//迟到条件 （1：> ,2:=,3:<）
    @ApiModelProperty(value = "早退条件 （1：> ,2:=,3:<）")
    private Integer earlyCondition;//早退条件 （1：> ,2:=,3:<）
    @ApiModelProperty(value = "请假条件 （1：> ,2:=,3:<）")
    private Integer leaveCondition;//请假条件 （1：> ,2:=,3:<）

    private static final long serialVersionUID = 1L;

}