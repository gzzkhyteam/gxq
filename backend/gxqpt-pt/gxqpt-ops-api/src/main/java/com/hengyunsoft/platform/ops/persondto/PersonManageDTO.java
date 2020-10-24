package com.hengyunsoft.platform.ops.persondto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author tianai
 * @createTime 2018-07-11
 */
@Data
public class PersonManageDTO implements Serializable{

    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;

    /**
     * 提供给前端判断是否已保存信息
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "personId")
    private Long personId;

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
     * 照片
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "照片")
    private String photo;

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
     * 所属职务id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属职务id")
    private String mainduty;

    /**
     * 所属职务名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属职务名称")
    private String maindutyname;

    /**
     * 手机1
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机1")
    private String mainmobile;


    /**
     * 高新区平台中的用户id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "高新区平台中的用户id")
    private Long gxqptEmpId;


    /**
     * 编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 编号")
    private String userCode;

    /**
     * 主要工作内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主要工作内容")
    private String  content;

    /**
     * 主要负责系统(系统名称)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主要负责系统")
    private List<ChargeSystemDTO> systemName;

}
