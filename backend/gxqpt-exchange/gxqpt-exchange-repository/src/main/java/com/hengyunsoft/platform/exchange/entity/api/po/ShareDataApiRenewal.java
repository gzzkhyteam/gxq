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
@ApiModel(value = "ShareDataApiRenewal", description = "")
public class ShareDataApiRenewal extends BaseEntity<Long> implements Serializable {
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
     * api管理id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "api管理id")
    @FieldDesc("api管理id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long apiId;

    /**
     * 单位Id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位Id")
    @FieldDesc("单位Id")
    @Length(max=64)
    private String unitId;

    /**
     * 申请期限:-1表示不受限制；单位（天）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请期限:-1表示不受限制；单位（天）")
    @FieldDesc("申请期限:-1表示不受限制；单位（天）")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dateTerm;

    /**
     * 续期理由
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "续期理由")
    @FieldDesc("续期理由")
    @Length(max=2147483647)
    private String rewalReason;

    /**
     * 申请人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人")
    @FieldDesc("申请人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long userId;

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请时间")
    @FieldDesc("申请时间")
    private Date applyTime;

    /**
     * 状态:1,待审批；2，已驳回；3，审批通过；
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态:1,待审批；2，已驳回；3，审批通过；")
    @FieldDesc("状态:1,待审批；2，已驳回；3，审批通过；")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer authStatus;

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