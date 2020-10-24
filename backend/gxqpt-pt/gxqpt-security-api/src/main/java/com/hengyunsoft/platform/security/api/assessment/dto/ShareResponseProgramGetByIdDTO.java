package com.hengyunsoft.platform.security.api.assessment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ShareResponseProgramGetById", description = "程序发布ID查询返回信息")
public class ShareResponseProgramGetByIdDTO implements Serializable {

    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用id")
    private String appId;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    private String name;

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
     * 升级时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "升级时间")
    private Date upgradeTime;

    /**
     * 发布文件id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布文件id")
    private Long upgradeFileId;

    /**
     * 发布文件链接
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布文件链接")
    private String upgradeFileUrl;

    /**
     * 发布文件名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布文件名称")
    private String upgradeFileName;

    /**
     * 服务ip
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务ip")
    private String serverIp;

    /**
     * 审批状态 0 未审核 1 已审核
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批状态 0 未审核 1 已审核")
    private Integer auditStatus;

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

    /**
     * 备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
