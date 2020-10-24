package com.hengyunsoft.platform.security.api.assessment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ShareResponseProgramSave", description = "程序发布列表返回信息")
public class ShareResponseProgramSaveDTO implements Serializable {

    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    private String name;

    /**
     * 发布时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布时间")
    private Date upgradeTime;

    /**
     * 审批状态 0 未审核 1 已审核
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批状态 0 未审核 1 已审核")
    private Integer auditStatus;

    /**
     * 版本名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "版本名称")
    private String versionName;

    /**
     * 版本号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "版本号")
    private String versionId;

    /**
     * 升级内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "升级内容")
    private String upgradeConent;

    /**
     * 服务ip
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务ip")
    private String serverIp;

    /**
     * 审批时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批时间")
    private Date auditTime;

    /**
     * 审批人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人")
    private String auditUser;
}
