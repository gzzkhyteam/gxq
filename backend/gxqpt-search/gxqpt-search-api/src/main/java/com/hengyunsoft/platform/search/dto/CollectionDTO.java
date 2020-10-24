package com.hengyunsoft.platform.search.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.search.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：gbl
 * 修改时间：2018/4/9
 * 修改内容：新增
 */
@Data
@ApiModel(value = "CollectionRes", description = "集合数据")
public class CollectionDTO {

    @ApiModelProperty(value = "集合id")
    private Long id;

    @ApiModelProperty(value = "集合名称")
    private String collectionName;

    @ApiModelProperty(value = "集合编码")
    private String collectionCode;

    @ApiModelProperty(value = "创建集合的appId")
    private String appId;
}
