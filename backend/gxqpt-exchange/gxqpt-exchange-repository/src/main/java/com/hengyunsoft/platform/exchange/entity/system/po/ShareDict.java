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
@ApiModel(value = "ShareDict", description = "")
public class ShareDict extends BaseEntity<Long> implements Serializable {
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
     * 名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "名称")
    @FieldDesc("名称")
    @Length(max=100)
    @NotNull(groups=MustNoneNull.class)
    private String dictName;

    /**
     * 编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编码")
    @FieldDesc("编码")
    @Length(max=100)
    @NotNull(groups=MustNoneNull.class)
    private String dictCode;

    /**
     * 描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "描述")
    @FieldDesc("描述")
    @Length(max=1000)
    private String describe;

    /**
     * 父编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "父编码")
    @FieldDesc("父编码")
    @Length(max=20)
    private String pId;

    /**
     * 层级
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "层级")
    @FieldDesc("层级")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer level;

    /**
     * 排序号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "排序号")
    @FieldDesc("排序号")
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