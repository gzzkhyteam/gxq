package com.hengyunsoft.platform.search.queue.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.search.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：删除索引DTO
 * 修改人：sxy
 * 修改时间：2018/8/9
 * 修改内容：新建
 */
@Data
@ApiModel(value = "DeleteIndexDTO", description = "删除索引DTO")
public class DeleteIndexDTO {

    @ApiModelProperty(value = "索引主键id")
    private String id;

    @ApiModelProperty(value = "索引集合")
    private String collection;

}

