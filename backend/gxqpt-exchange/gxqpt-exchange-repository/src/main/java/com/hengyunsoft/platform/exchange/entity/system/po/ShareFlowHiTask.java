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
@ApiModel(value = "ShareFlowHiTask", description = "")
public class ShareFlowHiTask extends BaseEntity<Long> implements Serializable {
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
     * 流程名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "流程名称")
    @FieldDesc("流程名称")
    @Length(max=100)
    private String procName;

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
     * 办理人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "办理人id")
    @FieldDesc("办理人id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long userId;

    /**
     * 办理人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "办理人姓名")
    @FieldDesc("办理人姓名")
    @Length(max=32)
    private String userName;

    /**
     * 任务开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "任务开始时间")
    @FieldDesc("任务开始时间")
    private Date startTime;

    /**
     * 任务结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "任务结束时间")
    @FieldDesc("任务结束时间")
    private Date endTime;

    /**
     * 办理时限(单位小时)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "办理时限(单位小时)")
    @FieldDesc("办理时限(单位小时)")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Float timeLimit;

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