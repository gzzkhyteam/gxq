package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "ApplyManageApprDTO", description = "审批详情")
public class ApplyManageApprDTO {

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
     * 附件
     */
    @ApiModelProperty(value = "附件集合")
    private List<AttachmentDTO> attachment;

    /**
     * 服务器申请
     */
    @ApiModelProperty(value = "服务器申请")
    private List<ApplyServerDTO> applyServer;

    /**
     * 每一个环节的特定标识（避免多个字段确认一个环节）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "每一个环节的特定标识")
    private String stepCode;

    /**
     * 每一个环节的特定环节名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "每一个环节的特定环节名称")
    private String stepName;

    /**
     * 大环节code（SQ，GL，UY，YY）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "大环节code（SQ，GL，UY，YY）")
    private String scode;

    /**
     * 大环节名称（申请方，管理员，国信优易，高新翼云）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "大环节名称（申请方，管理员，国信优易，高新翼云）")
    private String sname;

    /**
     * 申请类型(1新增2变更)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请类型(1新增2变更)")
    private String applyType;
}
