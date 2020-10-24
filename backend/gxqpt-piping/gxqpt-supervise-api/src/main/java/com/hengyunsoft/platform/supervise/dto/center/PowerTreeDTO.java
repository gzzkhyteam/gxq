package com.hengyunsoft.platform.supervise.dto.center;


import com.hengyunsoft.platform.commons.utils.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：全责类型树DTO
 * @author zjr
 * @date 2018/03/28
 */
@Data
@ApiModel(value = "PowerTree", description = "全责类型树")
public class PowerTreeDTO extends TreeNode<PowerTreeDTO,Long>  implements Serializable {

    /**
     * 全责名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "全责名称")
    private String name;
    /**
     * 是否选中
     */
    @ApiModelProperty(value = "是否选中")
    private Boolean checked;

    private static final long serialVersionUID = 1L;

}
