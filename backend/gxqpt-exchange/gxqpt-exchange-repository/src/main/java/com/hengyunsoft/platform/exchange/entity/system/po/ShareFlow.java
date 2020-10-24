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
@ApiModel(value = "ShareFlow", description = "")
public class ShareFlow extends BaseEntity<Long> implements Serializable {
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
     * 办理时限:单位（天）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "办理时限:单位（天）")
    @FieldDesc("办理时限:单位（天）")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer timeLimit;

    /**
     * 办理人角色
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "办理人角色")
    @FieldDesc("办理人角色")
    @Length(max=100)
    private String handleRole;

    /**
     * 是否多人办理:1，是；2，否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否多人办理:1，是；2，否")
    @FieldDesc("是否多人办理:1，是；2，否")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer moreUser;

    /**
     * 环节序号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节序号")
    @FieldDesc("环节序号")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer indexNo;

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