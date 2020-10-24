package com.hengyunsoft.platform.warn.entity.domain;


import com.hengyunsoft.platform.commons.utils.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：预警类型树DTO
 * @author sxy
 * @date 2018/07/27
 */
@Data
@ApiModel(value = "WarnTreeDO", description = "预警类型树")
public class WarnTreeDO extends TreeNode<WarnTreeDO,Long>  implements Serializable {

    /**
     * 主键id
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 预警类型名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警类型名称")
    private String typeName;

    /**
     * 是否选中
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否选中")
    private Boolean checked;

    private static final long serialVersionUID = 1L;


}
