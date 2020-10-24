package com.hengyunsoft.platform.admin.api.core.dto.emp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "GxqptEmpImport", description = "人员信息")
public class GxqptEmpImportDTO implements Serializable {
    /**
     * 姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录账号")
    private String nickname;

    /**
     * 密码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "密码")
    private String password;


    /**
     * 性别
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 生日
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "生日")
    private String birthday;
    /**
     * 民族
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "民族")
    private String nation;

    /**
     * 所属单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属单位id")
    private String mainorgid;

    /**
     * 所属单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属单位名称")
    private String mainorgname;

    /**
     * 所属部门id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属部门id")
    private String maindeptid;

    /**
     * 所属部门名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属部门名称")
    private String maindeptname;

    /**
     * 办公电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "办公电话")
    private String officetel;

    /**
     * 手机1
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机1")
    private String mainmobile;

    /**
     * 手机2
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机2")
    private String submobile;

    /**
     * 是否单位管理员
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否单位管理员")
    private String isorgadmin;

    /**
     * 启用标记
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "启用标记")
    private String isenable;

    /**
     * 状态 1在职、 2 转职中、 3 离职、 4 退休
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态 1在职、 2 转职中、 3 离职、 4 退休")
    private String status;

    /**
     * 个人简介
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "个人简介")
    private String descrption;

    /**
     * 是否政协委员
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否政协委员")
    private String iscommittee;

    /**
     * 是否人大代表
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否人大代表")
    private String isdeputy;

    /**
     * 是否单位一把手
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否单位一把手")
    private String isheader;

    /**
     * 是否单位领导
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否单位领导")
    private String isleader;

    /**
     * 人员职责
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "人员职责")
    private String userduty;

    /**
     * 排序权重值赿小靠前
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "排序权重值赿小靠前")
    private Integer sortvalue;


    /**
     * 所属职务名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属职务名称")
    private String dutyname;

    /**
     * 所属岗位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属岗位名称")
    private String postname;

    @ApiModelProperty(value = "统一人员编号")
    private String empNo;


    @ApiModelProperty(value = "最高学历")
    private String education;
}
