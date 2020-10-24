package com.hengyunsoft.platform.ops.entity.fault.po;

import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * 表名：b_yw_log_management
 *
 * @mbggenerated do_not_delete_during_merge
 * addModelClassComment 242 
 */
@Data
@ApiModel(value = "LogManagement", description = "日志管理")
public class LogManagement extends com.hengyunsoft.base.entity.BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @FieldDesc("主键")
    @ApiModelProperty(value = "主键")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 编号
     *
     * @mbggenerated
     */
    @FieldDesc("编号")
    @ApiModelProperty(value = "编号")
    @Length(max=20)
    private String code;

    /**
     * 日志类别
     *
     * @mbggenerated
     */
    @FieldDesc("日志类别")
    @ApiModelProperty(value = "日志类别")
    @Length(max=20)
    private String logType;

    /**
     * 日志记录
     *
     * @mbggenerated
     */
    @FieldDesc("日志记录")
    @ApiModelProperty(value = "日志记录")
    @Length(max=200)
    private String logRecord;

    /**
     * 故障级别
     *
     * @mbggenerated
     */
    @FieldDesc("故障级别")
    @ApiModelProperty(value = "故障级别")
    @Length(max=20)
    private String faultLevel;

    /**
     * 故障分类
     *
     * @mbggenerated
     */
    @FieldDesc("故障分类")
    @ApiModelProperty(value = "故障分类")
    @Length(max=20)
    private String faultClassification;

    /**
     * 处理人
     *
     * @mbggenerated
     */
    @FieldDesc("处理人")
    @ApiModelProperty(value = "处理人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long dealUser;

    /**
     * 处理时间
     *
     * @mbggenerated
     */
    @FieldDesc("处理时间")
    @ApiModelProperty(value = "处理时间")
    private Date dealTime;

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

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;
}