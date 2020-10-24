package com.hengyunsoft.platform.supervise.entity.po;

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
@ApiModel(value = "PowerSupervise", description = "")
public class PowerSupervise extends com.hengyunsoft.base.entity.BaseEntity<Long> implements Serializable {
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 权责编码
     *
     * @mbggenerated
     */
    @FieldDesc("权责编码")
    @ApiModelProperty(value = "权责编码")
    @Length(max=64)
    private String code;

    /**
     * 权责类型
     *
     * @mbggenerated
     */
    @FieldDesc("权责类型")
    @ApiModelProperty(value = "权责类型")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long typeId;

    /**
     * 权责名称
     *
     * @mbggenerated
     */
    @FieldDesc("权责名称")
    @ApiModelProperty(value = "权责名称")
    @Length(max=20)
    private String name;

    /**
     * 责任事项
     *
     * @mbggenerated
     */
    @FieldDesc("责任事项")
    @ApiModelProperty(value = "责任事项")
    @Length(max=200)
    private String matter;

    /**
     * 执行单位
     *
     * @mbggenerated
     */
    @FieldDesc("执行单位")
    @ApiModelProperty(value = "执行单位")
    @Length(max=64)
    private String unit;

    /**
     * 法律规定
     *
     * @mbggenerated
     */
    @FieldDesc("法律规定")
    @ApiModelProperty(value = "法律规定")
    @Length(max=500)
    private String lawDesc;

    /**
     * 运行状态 启用:true 禁用:false
     *
     * @mbggenerated
     */
    @FieldDesc("运行状态 启用:true 禁用:false")
    @ApiModelProperty(value = "运行状态 启用:true 禁用:false")
    private Boolean runStatus;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @FieldDesc("创建人")
    @ApiModelProperty(value = "创建人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @FieldDesc("更新人")
    @ApiModelProperty(value = "更新人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 级别
     *
     * @mbggenerated
     */
    @FieldDesc("级别")
    @ApiModelProperty(value = "级别")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer level;

    /**
     * 系统ID
     *
     * @mbggenerated
     */
    @FieldDesc("系统ID")
    @ApiModelProperty(value = "系统ID")
    @Length(max=64)
    private String systemId;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @FieldDesc("系统名称")
    @ApiModelProperty(value = "系统名称")
    @Length(max=255)
    private String systemName;

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;
}