package com.hengyunsoft.platform.mt.api.work.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tianai
 * @createTime 2018-05-28
 */
@Data
public class WorkLogPageDTO implements Serializable{
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "  主键")
    private Long id;


    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 创建时间")
    private Date createDate;

    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户姓名")
    private String userName;
    /**
     * 所属单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 所属单位id")
    private String mainOrgId;

    /**
     * 所属部门名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 所属部门名称")
    private String mainDeptName;

    /**
     * 所属职务名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 所属职务名称")
    private String mainDutyName;


}
