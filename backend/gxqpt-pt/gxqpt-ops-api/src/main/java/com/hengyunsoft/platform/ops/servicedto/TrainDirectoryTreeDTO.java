package com.hengyunsoft.platform.ops.servicedto;

import com.hengyunsoft.platform.commons.utils.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "TrainDirectoryTreeDTO", description = "培训课程目录树")
public class TrainDirectoryTreeDTO extends TreeNode<TrainDirectoryTreeDTO,Long> implements Serializable{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "父id")
    private Long parentId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "层级")
    private Integer level;

    @ApiModelProperty(value = "培训类型")
    private String type;

    @ApiModelProperty(value = "培训名称")
    private String serviceName;
    
    @ApiModelProperty(value = "培训内容")
    private String serviceInfo;
}
