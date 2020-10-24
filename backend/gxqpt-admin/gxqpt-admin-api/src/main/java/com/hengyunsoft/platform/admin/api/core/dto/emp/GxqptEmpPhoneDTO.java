package com.hengyunsoft.platform.admin.api.core.dto.emp;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 前提:1,登录人
 * 条件:正常单位，部门+人
 * 返回：name+phone
 * 形式:树
 */
@Data
@ApiModel(value = "GxqptEmpPhoneDTO", description = "人员信息")
public class GxqptEmpPhoneDTO implements Serializable {

    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "姓名")
    private String name;


    /**
     * 姓名
     * 2018-08-28新增返回登陆名，移动端lgr需要
     * @mbggenerated
     */
    @ApiModelProperty(value = "登陆账号")
    private String nickname;

    /**
     * 高新区平台用户id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "高新区平台用户id")
    private String gxqptEmpId;
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


    @ApiModelProperty(value = "照片")
    private String photo;

}
