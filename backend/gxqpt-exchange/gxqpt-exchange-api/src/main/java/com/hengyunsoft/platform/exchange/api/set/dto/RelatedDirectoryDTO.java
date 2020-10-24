package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述： 选择关联目录数据
 * 修改人：gbl
 * 修改时间：2018/4/23
 * 修改内容：
 */
@Data
@ApiModel(value = "RelatedDirectory", description = "择关联目录数据")
public class RelatedDirectoryDTO {
    @ApiModelProperty(value = "目录id")
    private long directoryId;
    @ApiModelProperty(value = "目录名称")
    private String name;

    @ApiModelProperty(value = "目录字段对应数据集字段")
    private List<DirectoryField2DataFieldDTO> list;
}
