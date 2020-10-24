package com.hengyunsoft.platform.supervise.dto.ledger;


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
@ApiModel(value = "WarnTree", description = "预警类型树")
public class WarnTypeTreeDTO extends TreeNode<WarnTypeTreeDTO,Long>  implements Serializable {

    /**
     * 预警类型名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警类型名称")
    private String typeName;

    /**
     * 父id
     * @mbggenerated
     */
    @ApiModelProperty(value = "父id")
    private Long parentId = 0L;


    /**
     * 是否选中
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否选中")
    private Boolean checked;

    private static final long serialVersionUID = 1L;



}
