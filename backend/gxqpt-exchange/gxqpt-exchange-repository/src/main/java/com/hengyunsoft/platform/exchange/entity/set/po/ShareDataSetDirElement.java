package com.hengyunsoft.platform.exchange.entity.set.po;

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
@ApiModel(value = "ShareDataSetDirElement", description = "")
public class ShareDataSetDirElement extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    @FieldDesc("主键id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 数据集关联目录字段表的id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据集关联目录字段表的id")
    @FieldDesc("数据集关联目录字段表的id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long sdId;

    /**
     * 数据集id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据集id")
    @FieldDesc("数据集id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long setId;

    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long dirId;

    /**
     * 目录字段id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录字段id")
    @FieldDesc("目录字段id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long dirFieldId;

    /**
     * 目录字段标识
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录字段标识")
    @FieldDesc("目录字段标识")
    @Length(max=128)
    private String dirFieldCode;

    /**
     * 目录字段名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录字段名称")
    @FieldDesc("目录字段名称")
    @Length(max=128)
    private String dirFieldName;

    /**
     * 数据集字段标识
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据集字段标识")
    @FieldDesc("数据集字段标识")
    @Length(max=128)
    private String setFieldCode;

    /**
     * 操作类型(最近一次)：1,新增；2，删除；3，编辑，4,正常,
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作类型(最近一次)：1,新增；2，删除；3，编辑，4,正常,")
    @FieldDesc("操作类型(最近一次)：1,新增；2，删除；3，编辑，4,正常,")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer optType;

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