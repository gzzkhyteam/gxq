package com.hengyunsoft.platform.supervise.dto.center;

import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 权责监管更新环节编号DTO
 * @author sxy
 * @date 2018-09-12
 */
@Data
@ApiModel(value = "PowerSuperviseLinkUpdateSortDTO",description = "权责监管更新环节编号DTO")
public class PowerSuperviseLinkUpdateSortDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * ID
     *
     * @mbggenerated
     */
    @FieldDesc("ID1")
    @ApiModelProperty(value = "ID1")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=ValidatorGroups.MustNoneNull.class)
    private Long firstId;

    /**
     * 排序编号
     *
     * @mbggenerated
     */
    @FieldDesc("排序编号1")
    @ApiModelProperty(value = "排序编号1")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer firstSortNum;

    /**
     * ID
     *
     * @mbggenerated
     */
    @FieldDesc("ID2")
    @ApiModelProperty(value = "ID2")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=ValidatorGroups.MustNoneNull.class)
    private Long secondId;

    /**
     * 排序编号
     *
     * @mbggenerated
     */
    @FieldDesc("排序编号2")
    @ApiModelProperty(value = "排序编号2")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer secondSortNum;


}
