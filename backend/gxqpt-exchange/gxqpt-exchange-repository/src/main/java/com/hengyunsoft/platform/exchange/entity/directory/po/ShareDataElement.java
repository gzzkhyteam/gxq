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
@ApiModel(value = "ShareDataElement", description = "")
public class ShareDataElement extends BaseEntity<Long> implements Serializable {
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
     * 目录id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录id")
    @FieldDesc("目录id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long dirId;

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
     * 字段名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段名称")
    @FieldDesc("字段名称")
    @Length(max=128)
    private String fieldName;

    /**
     * 字段标识
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段标识")
    @FieldDesc("字段标识")
    @Length(max=128)
    private String fieldCode;

    /**
     * 字段类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段类型")
    @FieldDesc("字段类型")
    @Length(max=64)
    private String fieldType;

    /**
     * 字段长度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段长度")
    @FieldDesc("字段长度")
    @Length(max=64)
    private String fieldLength;

    /**
     * 字段描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段描述")
    @FieldDesc("字段描述")
    @Length(max=200)
    private String desc;

    /**
     * 数据集字段
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据集字段")
    @FieldDesc("数据集字段")
    @Length(max=128)
    private String setField;

    /**
     * 审批状态:1,未发布；2，审批中；3，驳回；4，已发布；
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批状态:1,未发布；2，审批中；3，驳回；4，已发布；")
    @FieldDesc("审批状态:1,未发布；2，审批中；3，驳回；4，已发布；")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer status;

    /**
     * 是否主键：1是
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否主键：1是")
    @FieldDesc("是否主键：1是")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer isPrimary;

    /**
     * 操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用5，正常,6,启用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用5，正常,6,启用")
    @FieldDesc("操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用5，正常,6,启用")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer optType;

    /**
     * 数据状态；1，正常；2，已删除；3，已禁用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据状态；1，正常；2，已删除；3，已禁用")
    @FieldDesc("数据状态；1，正常；2，已删除；3，已禁用")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dataStatus;

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