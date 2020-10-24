package com.hengyunsoft.platform.hardware.dto.apply;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "ApplyQueryRetListDTO", description = "申请查询返回")
public class ApplyQueryRetListDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 申请单号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请单号")
    private String applyNo;

    /**
     * 申请单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请单位id")
    private String applyOrgid;

    /**
     * 申请单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请单位名称")
    private String applyOrgname;

    /**
     * 申请人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人id")
    private String applyUid;

    /**
     * 审请人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审请人姓名")
    private String applyUname;

    /**
     * 申请类型(1新增2变更)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请类型(1新增2变更)")
    private String applyType;

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "申请时间")
    private Date applyTime;

    /**
     * 每一个环节的特定标识（避免多个字段确认一个环节）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节特定标识")
    private String stepCode;

    /**
     * 每一个环节的特定环节名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节特定名称")
    private String stepName;

    /**
     * 大环节code（SQ，GL，UY，YY）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 大环节code（SQ，GL，UY，YY）")
    private String scode;

    /**
     * 大环节名称（申请方，管理员，国信优易，高新翼云）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "大环节名称（申请方，管理员，国信优易，高新翼云）")
    private String sname;


    /**
     * 处理状态
     */
    @ApiModelProperty(value = "处理状态1已处理，2未处理")
    private String handleType;


    /**
     * 变更源，该表单由哪条服务器变更而来
     * 2019-04-24 测试提出的需求变更新增
     * @mbggenerated
     */
    @ApiModelProperty(value = "变更源，该表单由哪条服务器变更而来")
    private Long serverKeyid;

}
