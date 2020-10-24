package com.hengyunsoft.platform.exchange.entity.api.po;

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
@ApiModel(value = "ShareDataDemand", description = "")
public class ShareDataDemand extends BaseEntity<Long> implements Serializable {
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
     * 申请编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请编号")
    @FieldDesc("申请编号")
    @Length(max=100)
    private String applyCode;

    /**
     * 单位id（提出需求人员）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id（提出需求人员）")
    @FieldDesc("单位id（提出需求人员）")
    @Length(max=64)
    @NotNull(groups=MustNoneNull.class)
    private String unitId;

    /**
     * 单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位名称")
    @FieldDesc("单位名称")
    @Length(max=200)
    private String unitName;

    /**
     * 单位类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位类型")
    @FieldDesc("单位类型")
    @Length(max=300)
    private String unitType;

    /**
     * 联系人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "联系人姓名")
    @FieldDesc("联系人姓名")
    @Length(max=64)
    private String contName;

    /**
     * 联系人电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "联系人电话")
    @FieldDesc("联系人电话")
    @Length(max=32)
    private String contTel;

    /**
     * 联系人邮箱
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "联系人邮箱")
    @FieldDesc("联系人邮箱")
    @Length(max=128)
    private String contEmail;

    /**
     * 统一社会信用代码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "统一社会信用代码")
    @FieldDesc("统一社会信用代码")
    @Length(max=200)
    private String creditCode;

    /**
     * 需求内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "需求内容")
    @FieldDesc("需求内容")
    @Length(max=2147483647)
    private String content;

    /**
     * 用途
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用途")
    @FieldDesc("用途")
    @Length(max=2000)
    private String purpose;

    /**
     * 申请原因
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请原因")
    @FieldDesc("申请原因")
    @Length(max=2147483647)
    private String applyReason;

    /**
     * 处理部门id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理部门id")
    @FieldDesc("处理部门id")
    @Length(max=64)
    private String orgId;

    /**
     * api管理id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "api管理id")
    @FieldDesc("api管理id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long apiId;

    /**
     * 状态:1,待审批；2，已驳回；3，通过，待封装API；4，已封装API
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态:1,待审批；2，已驳回；3，通过，待封装API；4，已封装API")
    @FieldDesc("状态:1,待审批；2，已驳回；3，通过，待封装API；4，已封装API")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer status;

    /**
     * 预计封装api时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "预计封装api时间")
    @FieldDesc("预计封装api时间")
    private Date estimateTime;

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