package com.hengyunsoft.platform.warn.api.warntype.dto;


import com.hengyunsoft.platform.commons.utils.TreeNode;
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
@ApiModel(value = "WarnTreeList", description = "预警类型树")
public class WarnTreeListDTO extends TreeNode<WarnTreeListDTO,Long>  implements Serializable{


    /**
     * 预警类型id
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警编码")
    private Long id;
    /**
     * 预警类型名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警类型名称")
    private String name;
    /**
     * 是否选中
     */
    @ApiModelProperty(value = "是否选中")
    private Boolean checked;

    private static final long serialVersionUID = 1L;

}
