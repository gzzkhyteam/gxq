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
@ApiModel(value = "ShareDataApiFilter", description = "")
public class ShareDataApiFilter extends BaseEntity<Long> implements Serializable {
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
     * 数据目录字段Id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据目录字段Id")
    @FieldDesc("数据目录字段Id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long fieldId;

    /**
     * 筛选规则:1,大于；2，小于；3，等于；4，模糊
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "筛选规则:1,大于；2，小于；3，等于；4，模糊")
    @FieldDesc("筛选规则:1,大于；2，小于；3，等于；4，模糊")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer scrRule;

    /**
     * 筛选值
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "筛选值")
    @FieldDesc("筛选值")
    @Length(max=2147483647)
    private String scrValue;

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