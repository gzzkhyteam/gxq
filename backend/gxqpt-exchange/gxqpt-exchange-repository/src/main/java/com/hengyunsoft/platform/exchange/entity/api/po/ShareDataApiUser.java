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
@ApiModel(value = "ShareDataApiUser", description = "")
public class ShareDataApiUser extends BaseEntity<Long> implements Serializable {
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
     * 申请编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请编码")
    @FieldDesc("申请编码")
    @Length(max=100)
    private String applyCode;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    @FieldDesc("单位id")
    @Length(max=64)
    private String unitId;

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
     * 申请授权期限:-1表示不受限制；单位（天）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请授权期限:-1表示不受限制；单位（天）")
    @FieldDesc("申请授权期限:-1表示不受限制；单位（天）")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dateTerm;

    /**
     * 到期时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "到期时间")
    @FieldDesc("到期时间")
    private Date limitTime;

    /**
     * API密钥
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "API密钥")
    @FieldDesc("API密钥")
    @Length(max=64)
    private String secretKey;

    /**
     * 申请理由
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请理由")
    @FieldDesc("申请理由")
    @Length(max=2147483647)
    private String reason;

    /**
     * 是否订阅：1，是；2，否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否订阅：1，是；2，否")
    @FieldDesc("是否订阅：1，是；2，否")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer isTake;

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
     * 申请人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人id")
    @FieldDesc("申请人id")
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
     * API类型:1,主动创建；2，用户封装；3，用户申请；4，用户授权
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "API类型:1,主动创建；2，用户封装；3，用户申请；4，用户授权")
    @FieldDesc("API类型:1,主动创建；2，用户封装；3，用户申请；4，用户授权")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer apiType;

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