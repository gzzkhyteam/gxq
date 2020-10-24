package com.hengyunsoft.platform.supervise.dto.center;


import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 描述：全责类型DTO
 * @author zjr
 * @date 2018/09/12
 */
@Data
@ApiModel(value = "PowerSuperviseType", description = "全责类型DTO")
public class PowerSuperviseTypeDTO implements Serializable {

    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=ValidatorGroups.MustNoneNull.class)
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
     * 权责名称
     *
     * @mbggenerated
     */
    @FieldDesc("权责名称")
    @ApiModelProperty(value = "权责名称")
    @Length(max=64)
    private String name;

    /**
     * 层级
     *
     * @mbggenerated
     */
    @FieldDesc("层级")
    @ApiModelProperty(value = "层级")
    @Length(max=100)
    private String level;

    /**
     * 父节点ID
     *
     * @mbggenerated
     */
    @FieldDesc("父节点ID")
    @ApiModelProperty(value = "父节点ID")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long parentId;

    /**
     * 序号
     *
     * @mbggenerated
     */
    @FieldDesc("序号")
    @ApiModelProperty(value = "序号")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer orderNum;

    /**
     * 是否启用
     *
     * @mbggenerated
     */
    @FieldDesc("是否启用")
    @ApiModelProperty(value = "是否启用")
    private Boolean isEnable;

    /**
     * 类型描述
     *
     * @mbggenerated
     */
    @FieldDesc("类型描述")
    @ApiModelProperty(value = "类型描述")
    @Length(max=500)
    private String desc;

    private static final long serialVersionUID = 1L;

}
