package com.hengyunsoft.platform.admin.api.authority.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "UserEdit", description = "用户编辑实体")
public class UserEditDTO {

    /**
     * 用户id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户id")
    private Long id;

    /**
     * 密码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "姓名")
    private String name;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "生日")
    private Date birthday;

    /**
     * 民族
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "民族")
    private String nation;

    /**
     * 照片
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "照片")
    private String photo;

    /**
     * 办公电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "办公电话")
    private String officetel;

    /**
     * 手机
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机")
    private String phone;

    /**
     * 工作描述：  市长、管理员、局长等等   用于登陆展示
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "工作描述：  市长、管理员、局长等等   用于登陆展示")
    private String workDesc;

    /**
     * 工作状态 1,在职 2，离职
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "工作状态 1,在职 2，离职")
    private String workStatus;

    /**
     * 是否可登陆
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否可登陆")
    private Boolean loginable;

    /**
     * 个人简介
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "个人简介")
    private String descrption;

    /**
     * 排序权重值赿小靠前
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "排序权重值赿小靠前")
    private Integer sortValue;
}
