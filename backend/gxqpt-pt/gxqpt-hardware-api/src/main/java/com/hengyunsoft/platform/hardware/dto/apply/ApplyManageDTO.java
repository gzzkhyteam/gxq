package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "ApplyManageDTO", description = "申请管理")
public class ApplyManageDTO {


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
     * 申请类型(1新增2变更)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请类型(1新增2变更)")
    private String applyType;

    /**
     * 申请人邮箱
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人邮箱")
    private String applyEmail;

    /**
     * 申请原因
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请原因")
    private String applyReason;

    /**
     * 变更源，该表单由哪条服务器变更而来
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务器变更id")
    private Long serverKeyid;

    /**
     * 服务器申请
     */
    @ApiModelProperty(value = "服务器申请")
    private List<ApplyServerDTO> applyServer;

    /**
     * 附件
     */
    @ApiModelProperty(value = "附件集合")
    private List<AttachmentDTO> attachment;


    /**
     * 提交类型：1仅保存，2提交
     */
    @ApiModelProperty(value = "提交类型：1仅保存，2提交")
    private String type;

}
