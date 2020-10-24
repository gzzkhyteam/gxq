package com.hengyunsoft.platform.warn.api.warntype.dto;


import com.hengyunsoft.platform.commons.utils.TreeNode;
import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：预警类型树DTO
 * @author zjr
 * @date 2018/03/28
 */
@Data
@ApiModel(value = "WarnTree", description = "预警类型树")
public class WarnTreeDTO extends TreeNode<WarnTreeDTO,Long>  implements Serializable {

    /**
     * 预警类型名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警类型名称")
    private String typeName;
    /**
     * 是否选中
     */
    @ApiModelProperty(value = "是否选中")
    private Boolean checked;

    /**
     * 在本棵树上属于第几层
     */
    @ApiModelProperty(value = "在本棵树上属于第几层 根节点属于1层")
    private String leve;

    /**
     * 是否启用 1：启用 0：禁用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否启用 1：启用 0：禁用")
    private Boolean isEnable;
    private static final long serialVersionUID = 1L;

}
