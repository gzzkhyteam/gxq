package com.hengyunsoft.platform.exchange.entity.directory.po;

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
@ApiModel(value = "ShareDataChange", description = "")
public class ShareDataChange extends BaseEntity<Long> implements Serializable {
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
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    @FieldDesc("单位id")
    @Length(max=64)
    @NotNull(groups=MustNoneNull.class)
    private String unitId;

    /**
     * 操作人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作人id")
    @FieldDesc("操作人id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long userId;

    /**
     * 操作时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作时间")
    @FieldDesc("操作时间")
    private Date optTime;

    /**
     * 是否平台管理员：1是
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否平台管理员：1是")
    @FieldDesc("是否平台管理员：1是")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer isPtadmin;

    /**
     * 申请理由
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请理由")
    @FieldDesc("申请理由")
    @Length(max=1000)
    private String applicationReasons;

    /**
     * 状态:1,待发布；2，已驳回；3，审批通过；4，审批中
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态:1,待发布；2，已驳回；3，审批通过；4，审批中")
    @FieldDesc("状态:1,待发布；2，已驳回；3，审批通过；4，审批中")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer status;

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