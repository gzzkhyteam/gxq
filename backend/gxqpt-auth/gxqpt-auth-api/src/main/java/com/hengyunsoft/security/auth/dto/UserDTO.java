package com.hengyunsoft.security.auth.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDTO implements Serializable {

	/**
     * ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 账号
     *
     * @mbggenerated
     */
    private String account;

    /**
     * 姓名
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 性别
     *
     * @mbggenerated
     */
    private String sex;

    /**
     * 生日
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date birthday;

    /**
     * 民族
     *
     * @mbggenerated
     */
    private String nation;

    /**
     * 照片
     *
     * @mbggenerated
     */
    private String photo;

    /**
     * 办公电话
     *
     * @mbggenerated
     */
    private String officetel;

    /**
     * 手机
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * 工作描述：  市长、管理员、局长等等   用于登陆展示
     *
     * @mbggenerated
     */
    private String workDesc;

    /**
     * 状态 1启用   2、冻结
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 存在于哪些体系中，   用0表示不存在  1表示存在   最大支持63个体系
     *
     * @mbggenerated
     */
    private String ownSystem;

    /**
     * 个人简介
     *
     * @mbggenerated
     */
    private String descrption;

    /**
     * 用户类型   根据类型去关联更具体的用户信息   意思可以进行信息扩展
     *
     * @mbggenerated
     */
    private String type;

    /**
     * 是否可登录
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否可登录")
    private String loginable;

    /**
     * 工作状态：1,在职  2,离职
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "工作状态：1,在职  2,离职")
    private String workStatus;

    /**
     * 排序权重值赿小靠前
     *
     * @mbggenerated
     */
    private Integer sortValue;
}
