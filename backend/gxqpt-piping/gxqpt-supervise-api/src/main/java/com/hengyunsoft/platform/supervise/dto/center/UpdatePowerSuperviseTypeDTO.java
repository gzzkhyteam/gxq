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
 * 描述：编辑全责类型DTO
 * @author zjr
 * @date 2018/09/13
 */
@Data
@ApiModel(value = "UpdatePowerSuperviseTypeDTO", description = "编辑全责类型")
public class UpdatePowerSuperviseTypeDTO implements Serializable {

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
