package com.hengyunsoft.platform.exchange.entity.set.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
@ApiModel(value = "ShareDbColumnType", description = "")
public class ShareDbColumnType extends BaseEntity<Long> implements Serializable {
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
     * 原类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "原类型")
    @FieldDesc("原类型")
    @Length(max=100)
    private String sourceType;

    /**
     * 对应mysql的类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "对应mysql的类型")
    @FieldDesc("对应mysql的类型")
    @Length(max=100)
    private String mysqlType;

    /**
     * 建表是否需要长度(0不需要，1需要)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "建表是否需要长度(0不需要，1需要)")
    @FieldDesc("建表是否需要长度(0不需要，1需要)")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer isLength;

    /**
     * 是否有小数(0没有,1有)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否有小数(0没有,1有)")
    @FieldDesc("是否有小数(0没有,1有)")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer isScale;

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;
}