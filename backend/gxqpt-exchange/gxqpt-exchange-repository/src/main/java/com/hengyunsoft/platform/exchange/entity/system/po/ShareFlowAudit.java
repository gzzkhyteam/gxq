package com.hengyunsoft.platform.exchange.entity.system.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
@ApiModel(value = "ShareFlowAudit", description = "")
public class ShareFlowAudit extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    @FieldDesc("主键")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 流程编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "流程编码")
    @FieldDesc("流程编码")
    @Length(max=100)
    private String procCode;

    /**
     * 环节名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节名称")
    @FieldDesc("环节名称")
    @Length(max=100)
    private String nodeName;

    /**
     * 环节编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节编号")
    @FieldDesc("环节编号")
    @Length(max=100)
    private String nodeCode;

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请编号")
    @FieldDesc("申请编号")
    @Length(max=100)
    private String applyCode;

    /**
     * 审批人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人id")
    @FieldDesc("审批人id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long userId;

    /**
     * 审批人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人姓名")
    @FieldDesc("审批人姓名")
    @Length(max=64)
    private String userName;

    /**
     * 审批时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批时间")
    @FieldDesc("审批时间")
    private Date auditTime;

    /**
     * 状态:1,通过；2，驳回
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态:1,通过；2，驳回")
    @FieldDesc("状态:1,通过；2，驳回")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer status;

    /**
     * 审批意见
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批意见")
    @FieldDesc("审批意见")
    @Length(max=2000)
    private String content;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    @FieldDesc("创建时间")
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    @FieldDesc("创建人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    @FieldDesc("更新时间")
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人")
    @FieldDesc("更新人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;
}